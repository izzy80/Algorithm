import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int westCnt = Integer.parseInt(st.nextToken());
            int eastCnt = Integer.parseInt(st.nextToken());

            int[][] dp = new int[westCnt+1][eastCnt+1];
            for(int j=1; j<=eastCnt; j++){
                dp[1][j] = j;
            }

            for(int j = 2; j <= westCnt; j++){
                for(int k=1; k <= eastCnt; k++){
                    if(j==k) dp[j][k] = 1;
                    if(k> j) {
                        dp[j][k] = dp[j-1][k-1]+dp[j][k-1];
                    }
                }
            }
//            System.out.println(Arrays.deepToString(dp));
            System.out.println(dp[westCnt][eastCnt]);
        }
    }
}