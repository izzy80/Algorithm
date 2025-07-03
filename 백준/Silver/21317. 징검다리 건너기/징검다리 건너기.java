import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] jumpEnergy, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        jumpEnergy = new int[N][2];
        dp = new int[N][2];
        for(int i=0; i<N-1; ++i){
            st = new StringTokenizer(br.readLine());
            jumpEnergy[i][0] = Integer.parseInt(st.nextToken());
            jumpEnergy[i][1] = Integer.parseInt(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());
        dfs(0,0,0);

        int ans;
        if(dp[N-1][0] == 0){
            ans = dp[N-1][1];
        }
        else if(dp[N-1][1] == 0){
            ans = dp[N-1][0];
        }
        else{
            ans = Math.min(dp[N-1][0], dp[N-1][1]);
        }

        System.out.print(ans);
    }

    static void dfs(int idx, int energy, int biggestJump){
        if(N <= idx) return;

        if(dp[idx][biggestJump] == 0){
            dp[idx][biggestJump] = energy;
        }
        else{
            if(dp[idx][biggestJump] < energy) return;

            dp[idx][biggestJump] = energy;
        }

        dfs(idx+1, energy+jumpEnergy[idx][0], biggestJump);
        dfs(idx+2, energy+jumpEnergy[idx][1], biggestJump);
        if(biggestJump == 0) dfs(idx+3, energy+K, 1);
    }
}