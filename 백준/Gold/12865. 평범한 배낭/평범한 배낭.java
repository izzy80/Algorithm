import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 물품의 수
		int K = sc.nextInt(); // 준서가 버틸 수 있는 무게
		int[] weights = new int[N + 1];
		int[] values = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			values[i] = sc.nextInt();
		}
		
		int[][] dp = new int[N + 1][K + 1]; // 0부터 시작
		for (int i = 1; i <= N; i++) {// 행 돌기
			for (int w = 0; w <= K; w++) {
				if (weights[i] <= w) { 
					// 무게가 범위안에 들어가 있으면 가방 안에 집어넣을 수 있음
					dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i]] + values[i]);
				} else {
					// 무게가 범위를 벗어나가면 그 전 무게를 가져온다. 
					dp[i][w] = dp[i - 1][w];
				}

			}

		}
		System.out.println(dp[N][K]);

	}// main
}