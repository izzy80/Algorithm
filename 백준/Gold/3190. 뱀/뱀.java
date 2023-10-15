import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * - 사과를 먹으면 뱀 길이가 늘어난다.
 * - 벽 또는 자기자신의 몸과 부딪히면 게임이 끝난다.
 *
 * - 보드의 상하좌우 끝에는 벽이 있다.
 * - 뱀은 항상 맨위맨좌측에 위치한다. (1,1)
 *      - 뱀의 길이는 1. 처음에는 오른쪽을 향한다.
 * - 뱀이 이동할 때 몸길이는 +1이 된다.
 * 그런데 이동한 곳에 사과가 있으면 +1된 몸길이가 유지가 되고,
 * 아니면 몸길이가 원래대로 돌아오고 꼬리가 위치한 칸을 비운다.
 *
 * - 게임시작 시간으로부터 x초가 끝난 뒤에 방향회전을 한다.
 * D : 오른쪽으로 90도 회전
 * L : 왼쪽으로 90도 회전
 */
public class Main {
    static int N,K,L;
    static StringTokenizer st;
    static int[][] map;

    static HashMap<Integer, String> h = new HashMap<>();
    static List<int[]> snake = new ArrayList<>();
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 }; // 동 남 서 북


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //보드의 크기
        map = new int[N][N];

        K = Integer.parseInt(br.readLine()); //사과의 개수

        for(int k=0;k<K;k++){ //사과의 위치 행,열
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r-1][c-1] = 1; //사과의 위치
        }

        L = Integer.parseInt(br.readLine());//뱀의 방향 변환 정보
        for(int l=0;l<L;l++){//
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            h.put(x,c);
        }
//        System.out.println(Arrays.deepToString(map));

        //풀이
        solve();

    }//main

    private static void solve() {
        int cr = 0;
        int cc = 0;

        int time =0;
        int dir = 0;

        snake.add(new int[] { 0, 0 });

        outer : while(true){
            //시간 증가
            time++;

            //뱀 이동
            int nr = cr+dr[dir];
            int nc = cc+dc[dir];

            //종료 처리
            if(nr < 0|| nr >= N || nc < 0||nc >= N) break;
            for(int i=0; i<snake.size();i++){
                int[] t = snake.get(i);
                if(nr == t[0] && nc == t[1]) break outer;
            }

            //사과 처리
            if(map[nr][nc] == 1){
                map[nr][nc] = 0; //사과 지욱;
                snake.add(new int[]{nr,nc}); //머리 추가
            }
            else{
                snake.add(new int[]{nr,nc}); //머리 추가
                snake.remove(0); //꼬리 지움
            }

            //방향 바꾸기
            if(h.containsKey(time)){
                if(h.get(time).equals("D")){
                    dir+=1;
                    if(dir==4){
                        dir =0;
                    }
                }
                else{
                    dir-=1;
                    if(dir == -1){
                       dir = 3;
                    }
                }
            }

            //현재값
            cr = nr;
            cc = nc;
        }
        System.out.println(time);

    }
}