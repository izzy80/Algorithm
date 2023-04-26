import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 0;tc<T;tc++) {
			int N = sc.nextInt();
			long[] dp = new long[N+1];
			dp[1] = 1; 
			if(N>=2) {
				dp[2] = 1;
			}
			if(N>=3) {
				dp[3] = 1;
			}
			for(int i=4;i<=N;i++) {
				dp[i] = dp[i-2]+dp[i-3];
			}
			System.out.println(dp[N]);
		}// tc for문
	}//main
		
}