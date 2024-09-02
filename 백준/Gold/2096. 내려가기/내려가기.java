import java.util.*;
import java.io.*;

public class Main {
    static int[] movec = {-1, 0, 1}; // 이동 가능한 열의 차이 (왼쪽, 그대로, 오른쪽)
    static int COL_SIZE = 3; // 열의 크기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];
        long[][][] dp = new long[N][3][2]; // dp[i][j][0] : 최댓값, dp[i][j][1] : 최솟값
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < COL_SIZE; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫째 줄 초기화
        for (int i = 0; i < COL_SIZE; i++) {
            dp[0][i][0] = map[0][i]; // 최댓값 초기화
            dp[0][i][1] = map[0][i]; // 최솟값 초기화
        }

        // DP 배열 채우기
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < COL_SIZE; j++) {
                long max = Long.MIN_VALUE; // 최댓값 초기화
                long min = Long.MAX_VALUE; // 최솟값 초기화
                for (int m = 0; m < 3; m++) {
                    int nc = j + movec[m]; // 다음 열 위치 계산

                    if (nc >= 0 && nc < COL_SIZE) { // 유효한 범위 내에서만
                        max = Math.max(max, dp[i - 1][nc][0] + map[i][j]); // 이전 행에서 최댓값과 현재 값을 더하여 최댓값 갱신
                        min = Math.min(min, dp[i - 1][nc][1] + map[i][j]); // 이전 행에서 최솟값과 현재 값을 더하여 최솟값 갱신
                    }
                }
                dp[i][j][0] = max; // 현재 위치에서의 최댓값 저장
                dp[i][j][1] = min; // 현재 위치에서의 최솟값 저장
            }
        }

        // 결과 계산
        StringBuilder sb = new StringBuilder();
        long ans_max = Long.MIN_VALUE;
        long ans_min = Long.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            ans_max = Math.max(ans_max, dp[N - 1][i][0]); // 마지막 행의 최댓값 중 가장 큰 값
            ans_min = Math.min(ans_min, dp[N - 1][i][1]); // 마지막 행의 최솟값 중 가장 작은 값
        }
        sb.append(ans_max).append(" ").append(ans_min);

        System.out.println(sb.toString());
    }
}