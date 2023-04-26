import java.util.Scanner;

public class Main {
	static int M,N;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=0;tc<T;tc++) {
			N =sc.nextInt(); // 서쪽 
			M = sc.nextInt(); // 동쪽 
			dp = new int[M+1][N+1];
			// 초기화
			for(int i=0;i<=M;i++) {
				dp[i][0] = 1;
			}
			for(int i=0;i<=N;i++) {
				dp[0][i] = 1;
			}
			for(int i=0;i<=N;i++) {
				dp[i][i] = 1;
			}

			factorial(M,N);
			System.out.println(dp[M][N]);
			
		}// tc for문
	}
	public static int factorial(int m, int n) {
		if(dp[m][n]==0) {
			dp[m][n] = factorial(m-1,n-1)+factorial(m-1,n);
		}
		
		return dp[m][n];
	}
	
}