import java.util.*;
import java.io.*;

/*
비어있는 곳 : .
물이 차있는 지역 : *
돌 : X
비버의 굴 : D
고슴도치의 위치 : S

매 분마다 고슴도치는 인접한 칸으로 이동
물도 매분마다 비어있는 칸으로 확장
물과 고슴도치는 돌을 통과할 수 없다.
고슴도치는 물로 차있는 구역으로 이동불가능
물도 비버의 소굴로 이동 불가능
고슴도치가 안전하게 비버의 굴로 이동하기 위해 필요한 최소 시간은?


 */
public class Main {
    static int answer =Integer.MAX_VALUE;

    static int R,C;
    static char[][] map;
    static boolean[][] visited;
    static Queue<int[]> q = new ArrayDeque<>();
    static Queue<int[]> wq = new ArrayDeque<>();

    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};

    static final char EMPTY = '.';
    static final char WATER = '*';
    static final char ROCK = 'X';
    static final char START = 'S';
    static final char END = 'D';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        int startr = 0;
        int startc = 0;
        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j=0; j < C; j++){
                char c = str.charAt(j);
                map[i][j] = c;

                if(c == WATER){
                    //처음 물이 있으면 wq에 다 집어넣기.
                    wq.add(new int[]{i,j});
                }
                if(c == START){
                    //처음 고슴도치의 위치 q에 집어넣기
                    q.add(new int[]{i,j,0});
                }
            }
        }

        //solve
        bfs();

        //print
        System.out.println(answer==Integer.MAX_VALUE?"KAKTUS":answer);


    }

    public static void bfs() {
        //while()로 처리 안 하는 이유는
        //len이 한 턴이기 때문
        //각 큐의 사이즈만큼 -> 한 depth

        //q에는 비버의 이동이 들어가 있음
        //q가 비어있으면 비버가 이동을 안 함.
        //어차피 물이 들어올 예정이라면 비버는 이동을 못 함.
        //홍수 처리 먼저한다.
        while (!q.isEmpty()) {

            // 물 퍼뜨림
            int len = wq.size();
            //처음 퍼져야 하는 물이 담긴 wq
            //그만큼만 for문을 돌리고 다음 턴을 위해 wq에 물을 다시 넣어준다.
            for(int i=0;i<len;i++){
                int[] now = wq.poll();
                int cr = now[0];
                int cc = now[1];

                for (int m= 0; m < 4; m++) {
                    int nr = cr + mover[m];
                    int nc = cc + movec[m];
                    if(nr < 0 || nr >= R || nc <0 || nc >= C) continue;
                    if(map[nr][nc] == EMPTY){
                        //비어있으면
                        map[nr][nc] = WATER; //물로 바꿔주고
                        wq.add(new int[]{nr,nc}); //다음 턴을 위해 wq에 값 넣기
                    }
                }
            }

            // 고슴도치 이동
            len = q.size();
            for(int i=0;i<len;i++){
                int[] now = q.poll();
                int cr = now[0];
                int cc = now[1];
                int time = now[2];

                for (int m= 0; m < 4; m++) {
                    int nr = cr + mover[m];
                    int nc = cc + movec[m];
                    if(nr < 0 || nr >= R || nc <0 || nc >= C) continue;
                    if(map[nr][nc] == END){
                        //비버의 집에 도착하면 answer 갱신
                        answer=Math.min(answer,time+1);
                        return;
                    }
                    else if(map[nr][nc] == EMPTY){
                        //비어있다면 다음 고슴도치의 위치 갱신
                        map[nr][nc] = 'S';
                        q.add(new int[]{nr,nc,time+1});
                    }
                }
            }
        }
    }
}