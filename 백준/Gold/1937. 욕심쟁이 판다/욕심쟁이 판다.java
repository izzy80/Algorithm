import java.util.*;
import java.io.*;


public class Main {
    static int N;
    static int[][] panda;
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};
    static int answer = 0;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        panda = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < N; j++){
                panda[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        System.out.println(Arrays.deepToString(panda));

        //solve
        dp = new int[N][N];
        for(int i=0; i < N; i++){
            for(int j=0; j < N; j++){
                answer = Math.max(answer, dfs(i,j));
            }
        }

        //print
        System.out.println(answer);
    }

    public static int dfs(int r, int c){
        if(dp[r][c] != 0)
            return dp[r][c];

        dp[r][c] = 1;
        for(int m=0; m < 4; m++){
            int nr = r + mover[m];
            int nc = c + movec[m];

            if(nr <0 || nr >= N || nc <0 || nc >= N) continue;
            if(panda[nr][nc] <= panda[r][c]) continue;
            //이동하는 곳이 기존 곳 보다 크다면 이동 가능
            dp[r][c] = Math.max(dp[r][c], dfs(nr,nc)+1);
        }
        return dp[r][c];
    }
}