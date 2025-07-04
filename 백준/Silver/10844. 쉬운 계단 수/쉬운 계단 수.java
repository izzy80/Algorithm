import java.util.*;
import java.io.*;

class Main {
    static final long DIV = 1_000_000_000L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int N = Integer.parseInt(br.readLine()); 

        long[][] dp = new long[N+1][10];
        
        for(int i = 1; i <= 9; i++){
            dp[1][i] = 1;
        }
        
        for(int i = 2; i <= N; i++){
            for(int j = 0; j <= 9; j++){
                if(j == 0){
                    dp[i][0] = dp[i-1][1] % DIV;
                } else if(j == 9){
                    dp[i][9] = dp[i-1][8] % DIV;
                } else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % DIV;
                }
            }
        }
        
        long answer = 0;
        for(int i = 0; i <= 9; i++){
            answer = (answer + dp[N][i]) % DIV;
        }
        System.out.println(answer);
    }
}
