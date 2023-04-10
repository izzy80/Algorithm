import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1;tc<=T;tc++) {
			int N = sc.nextInt(); // 재료의 수 
			int L = sc.nextInt(); // 제한 칼로리
			
			int[] score = new int[N+1];
			int[] kal = new int[N+1];
			
			for(int i=1;i<=N;i++) {
				score[i] = sc.nextInt();
				kal[i] = sc.nextInt();
			}
			
			int[][] dp = new int[N+1][L+1];
			for(int i=1;i<=N;i++) {
				for(int l=0;l<=L;l++) {
					if(kal[i] <= l) {
						dp[i][l] = Math.max(dp[i-1][l], dp[i-1][l-kal[i]]+score[i]);
					}
					else {
						dp[i][l] = dp[i-1][l]; 
					}
				}
			}
			
			System.out.println("#"+tc+" "+dp[N][L]);
			
		}// tc
	}// main 

}
