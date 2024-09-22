import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N][M];

        int max = 0;
        for(int i=0; i< N; i++){
            String str = br.readLine();
            for(int j=0; j < M; j++){
                int num = str.charAt(j)-'0';
                if(num == 0){
                    //현재 칸이 0이면 dp도 0. 사각형을 만들 수 없으니까
                    dp[i][j] = 0;
                    continue;
                }
                //현재칸이 0이 아니고 1이라는 것
                //현재 칸이 1일때, 현재칸 기준으로 왼쪽, 위쪽, 옆쪽 세 칸을 보는데.
                //이 세값 중에 최소값을 가져와서 dp[현재칸][] = 최소값+1 
                if(i-1 < 0 || j-1 < 0){
                    dp[i][j] =1;
                    max = Math.max(max, dp[i][j]);
                    continue;
                }

                int left = dp[i][j-1];
                int up = dp[i-1][j];
                int up_left = dp[i-1][j-1];

                int min = left;
                min = Math.min(min, up);
                min = Math.min(min, up_left);

                dp[i][j] = min+1;
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max*max);
    }
}