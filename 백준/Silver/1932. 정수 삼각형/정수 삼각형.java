import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 삼각형의 크기
		int[][] nums = new int[n][n];
		int[][] dp = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				nums[i][j]=sc.nextInt();
			}
		}
		// 초기값 설정 
		// 1. 맨 첫번째 열 초기값 지정 
		int sum = 0;
		for(int i=0;i<n;i++) {
			sum+=nums[i][0];
			dp[i][0] = sum;
		}
		
		// 2. 행과 열이 같으면 초기값 지정 
		sum = 0;
		for(int i=0;i<n;i++) {
			sum+=nums[i][i];
			dp[i][i] = sum;
		}
		
		// 3. dp 돌리기 
		for(int i=2;i<n;i++) {
			for(int j=1;j<=i;j++) {
				if(dp[i][j]==0) {
					dp[i][j] = Math.max(dp[i-1][j-1]+nums[i][j], dp[i-1][j]+nums[i][j]); 	
				} // if문
			}// j for문
		}// i for문
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			if(max <dp[n-1][i]) {
				max = dp[n-1][i];
			}
		}
		//System.out.println(Arrays.deepToString(dp));
		
		
		
		
		
		// 결과 출력 
		System.out.println(max);
	}// main	
}