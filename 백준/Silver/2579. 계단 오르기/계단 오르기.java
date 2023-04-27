import java.util.Scanner;

public class Main {
	static Integer dp[];
	static int[] score;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int result = 0; 
		
		score = new int[N+1];
		dp = new Integer[N+1];
		for(int i=1;i<=N;i++) {
			score[i] = sc.nextInt();
		}
		
		dp[0] = score[0];
		dp[1] = score[1];
		
		if(N>=2) {
			dp[2] = score[1]+score[2];
		}
		
		System.out.println(dpdp(N));
	}// main
	private static int dpdp(int N) {
		if(dp[N] == null) {
			dp[N] = Math.max(dpdp(N-2), dpdp(N-3)+score[N-1])+score[N];
		}
		return dp[N];
	}
}