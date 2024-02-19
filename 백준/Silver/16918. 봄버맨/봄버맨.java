import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 연쇄반응이 없다. -> 한 꺼번에 다 집어넣는 게 아니라 폭탄이 있을 때 BFS 시작
 */

public class Main {
    static int R,C,N;
    static char[][] map;
    static int[][] copy;
    static int[] mover = {-1, 1, 0, 0};
    static int[] movec = {0, 0, -1, 1};
    static Queue<int[]> q;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken()); //N초가 지난후의 지도의 상태

        map = new char[R][C];
        copy = new int[R][C];
        for(int i=0; i < R; i++){
            for(int j=0; j < C; j++){
                Arrays.fill(copy[i], -1);
            }
        }

        for(int i=0; i < R; i++){
            String str = br.readLine();
            for(int j=0; j < C; j++){
                char c = str.charAt(j);
                map[i][j] = c;
                if(c == 'O'){
                    //폭탄의 위치에 시간 넣기
                    copy[i][j] = 0;
                }
            }
        }

        int time = 1;
        while(time <= N){
            //2. BFS 돌면서 폭탄 터트림
            q = new LinkedList<>();
            for(int i=0; i < R; i++){
                for(int j=0; j < C; j++){
                    if(copy[i][j] == 2){
                        q.add(new int[]{i, j});
                    }
                }
            }
            Boom();

            if(time % 2 == 0){//time이 1, 3, 5..일때는 폭탄 fill처리
                //1. 폭탄 처리
//                System.out.println("폭탄 처리");
                copy = fillBomb(copy);
            }
            else{
                //시간만 늘려줌
                for(int i=0; i < R; i++){
                    for(int j=0; j < C; j++){
                        if(copy[i][j]!=-1) //-1이 아니라면 폭탄이 설치. 그렇다면 폭탄 시간 count
                            copy[i][j]+=1;
                    }
                }
            }
//            System.out.println("시간은 ? "+time);
//            System.out.println(Arrays.deepToString(copy));
            time++; //시간 추가
        }

        //출력
        char[][] answer = new char[R][C];
        for(int i=0; i < R; i++){
            for(int j=0; j < C; j++){
               Arrays.fill(answer[i],'.');
            }
        }
        for(int i=0; i < R; i++){
            for(int j=0; j < C; j++){
                if(copy[i][j] > -1){
                    answer[i][j] = 'O';
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0; i < R; i++){
            for(int j=0; j < C; j++){
                sb.append(answer[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void Boom() {

        while(!q.isEmpty()){
            int[] cur = q.poll();
            copy[cur[0]][cur[1]] = -1;

            for(int m=0; m< 4; m++){
                int nr = cur[0] + mover[m];
                int nc = cur[1] + movec[m];

                if(nr <0 || nr >= R || nc < 0 || nc >= C) continue;
                copy[nr][nc] = -1;
            }
        }
    }

    private static int[][] fillBomb(int[][] copy) {
        for(int i=0; i < R; i++){
            for(int j=0; j < C; j++){
                copy[i][j]+=1;
            }
        }
        return copy;
    }
}