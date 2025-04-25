

import java.util.*;
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] value = new int[n];
        for(int i=0; i < n; i++){
            value[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(value); //오름차순으로 정렬

        //solve
        int[] dp = new int[k+1];
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;

        for(int i=0; i < n; i++){
            for(int j=value[i] ; j <= k; j++){
                dp[j] = Math.min(dp[j], dp[j-value[i]]+1);
            }
        }

        int answer = dp[k] == Integer.MAX_VALUE-1 ? -1 : dp[k];
        System.out.println(answer);
    }
}
