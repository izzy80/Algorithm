import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc =0; tc < T; tc++){
            int N = Integer.parseInt(br.readLine());

            //dp
            int[] dp = new int[N+1];

            // 초기값 설정
            if(N >= 1) dp[1] = 1;
            if(N >= 2) dp[2] = 2;
            if(N >= 3) dp[3] = 4;

            for(int i=4; i<=N; i++){
                dp[i] = dp[i-1] + dp[i-2] +dp[i-3];
            }
            //답
            System.out.println(dp[N]);
        }//tc for
    }//main
}