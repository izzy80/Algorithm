

import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int max;
    static int[][] dp;
    static String board, myWord;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        board = br.readLine();
        myWord  = br.readLine();

        //solve
        max = Integer.MIN_VALUE;

        for(int i=0; i < N; i++){
            max = Math.max(max, dfs(i,0));
        }

        //print
        System.out.println(max);
    }



    public static int dfs(int bIdx,int mIdx){
        if(mIdx == M){
            return 0;
        }
        if(dp[bIdx][mIdx] != -1){
            return dp[bIdx][mIdx];
        }

        int point = 0;
        if(bIdx > 0){
            point = dfs(bIdx-1, mIdx+1);
        }
        if(bIdx < N-1){
            point = Math.max(point, dfs(bIdx+1, mIdx+1));
        }
        if(board.charAt(bIdx) == myWord.charAt(mIdx)){
            point += 1; 
        }
        return dp[bIdx][mIdx] = point;
    }
}
