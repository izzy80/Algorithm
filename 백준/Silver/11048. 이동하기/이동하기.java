import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][M+1];
        int[][] dp = new int[N+1][M+1];

        for(int i=1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j <= M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //dp
        for(int i=1; i <= N; i++){
            for(int j=1; j <= M; j++){
                //대각선은 고려하지 않아도 된다.
                //대각선으로 가면 지나가는 갯수가 덜하기 때문. 바로 오는 것보다 어딜 거쳐서 지나오는 것이 더 사탕을 많이 먹음
                dp[i][j] = Math.max(map[i][j]+dp[i-1][j], map[i][j]+dp[i][j-1]);
            }
        }

        //출력
        System.out.println(dp[N][M]);
    }
}