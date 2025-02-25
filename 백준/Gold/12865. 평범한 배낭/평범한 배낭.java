import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); //물품의 수
        int W = Integer.parseInt(st.nextToken()); //무게

        int[][] items = new int[K+1][2];
        for(int i=1; i <= K; i++){
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken()); //물건의 무게
            items[i][1] = Integer.parseInt(st.nextToken()); //물건의 가치
        }

        int[][] dp = new int[K+1][W+1];

        for(int i=1; i <= K; i++){ //물품
            for(int j=1; j<=W;j++){ //무게
                if( items[i][0] <= j){
                    //무게 초과 x
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-items[i][0]]+items[i][1]);
                }
                else{
                    //무게 초과
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[K][W]);



    }
}