import java.util.*;
import java.io.*;


public class Main {
    static int N,M;
    static int[][] map;
    static int[][] dp;
    static int[] mover = {-1,1,0,0};
    static int[] movec = {0,0,-1,1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];

        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        answer = dfs(0,0);
        System.out.println(answer);

    }

    public static int dfs(int r, int c){
        if(r == N-1 && c == M-1){
            return 1; //끝까지 도달했다면 1
        }
        if(dp[r][c] != -1){ //방문 했다면
            return dp[r][c]; //이미 값이 있다면 그 값 return
        }
        //방문 안 했다면 0
        dp[r][c] = 0;

        for(int m = 0; m <4; m++){
            int nr = r + mover[m];
            int nc = c + movec[m];

            if(nr < 0 || nr >= N || nc <0 || nc >= M) continue;
            if(map[r][c] > map[nr][nc]){
                dp[r][c] += dfs(nr,nc);
            }
        }

        return dp[r][c];
    }
}