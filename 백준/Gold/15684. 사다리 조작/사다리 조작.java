import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 0 : 해당칸은 가로선 없음
 * 1 : 해당칸을 기준으로 우측으로 연결
 * 2 : 해당칸을 기준으로 좌측으로 연결
 */
public class Main {
    static int N,M,H;
    static int[][] map;
    static int ans;
    static boolean isFinish = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로선의 개수
        M = Integer.parseInt(st.nextToken()); //가로선의 개수
        H = Integer.parseInt(st.nextToken()); //세로선마다 가로선을 놓을 수 있는 위치의 개수

        map = new int[H+1][N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1; //우측 연결
            map[a][b+1] = 2;

        }

        for(int i=0; i<= 3; i++){//추가할 수 있는 선은 총 3개. 그 이상이면 -1을 출력
            ans = i;
            dfs(0);
            if(isFinish) break;
        }

        //출력
        System.out.println(isFinish?ans:-1);
    }

    static public void dfs(int addLine){
        if(isFinish) return;
        if(ans == addLine){
            if(check()) isFinish = true;
            return;
        }

        for(int i=1; i<=H; i++){//행 돈다(y)
            for(int j=1; j<N; j++){//열 돈다(x)
                //가로선 두개가 연속으로 놓아질 수 없다. 가로선 추가하기 전에 연결된 가로선 있는지 check
                if(map[i][j] == 0 && map[i][j+1] == 0){
                    //가로선 추가
                    map[i][j] =1;
                    map[i][j+1] = 2;

                    dfs(addLine+1);

                    //추가했던 가로선 다시 제거(백트래킹)
                    map[i][j] = 0;
                    map[i][j+1] = 0;
                }
            }

        }

    }

    //i번에서 출발해서 i번으로 도착을 하는지
    static public boolean check(){
        for(int i=1; i<=N; i++){
            int nx = i;
            int ny = 1;

            while(ny <= H){
                if(map[ny][nx] ==1) nx++; //우측으로 이동
                else if(map[ny][nx] == 2) nx--; //좌측으로 이동
                ny++; //y축+1칸 이동(아래로 이동)
            }
            if(nx != i) return false; //i번으로 출발해서 i번으로 도착하지 않는다는 것
        }
        return true;
    }
}