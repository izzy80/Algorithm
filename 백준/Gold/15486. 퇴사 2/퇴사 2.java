import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] arr =new int[n+2][2];
        int[] dp = new int[n+2];
        for(int i=1; i<n+1; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            arr[i][0] = t; // 기간
            arr[i][1] = p; // 금액
        }

        int max = -1;
        for(int i=1; i<=n+1; i++) {
            if(max < dp[i]) { //max 갱신
                max = dp[i];
            }

            //선택한 상담 다음 날
            //이 때부터 다시 상담 선택 가능
            int nxt = i +arr[i][0];
            if(nxt < n+2) {//범위 벗어나지 않게
                //다음 날에 dp[nxt]와 max값에 금액 더한 값 중 큰 값 선택 
                dp[nxt] = Math.max(dp[nxt], max+arr[i][1]);
            }
        }
        System.out.println(dp[n+1]);

    }
}