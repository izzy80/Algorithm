import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //삼각형의 크기
        int[][] triangle = new int[N][N];

        StringTokenizer st;
        int number = 1;
        for(int i = 0; i < N ;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < number ; j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
            number++;
        }

//        System.out.println(Arrays.deepToString(triangle));

        //solve
        int[][] dp = new int[N][N];
        dp[0][0] = triangle[0][0];
        for(int i=1; i<N;i++) {

            for(int j=0;j<N;j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }
                else if(j == i) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }

            }

        }

        int answer = 0 ;
        for(int i=0;i<N;i++) {
            answer = Math.max(dp[N-1][i], answer);
        }
        System.out.println(answer);



    }
}