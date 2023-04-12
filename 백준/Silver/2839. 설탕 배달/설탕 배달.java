import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 설탕 배달
		int[] dp = new int[N+1];
		
		if(N>=3) {
			dp[3] = 1;
		}
		if(N>=5) { // 조건문 안 걸어주면 N=3일 때 index오류 발생 
			dp[5] = 1;
		}
		
		for(int i=6;i<=N;i++) {//N=3일때 조건에 안 맞아서 돌아가지조차 않음. 
			if(i%5==0) { // 5를 먼저 나누어주어야 작은 봉지 수를 가져온다. 
				dp[i] = dp[i-5]+1;
			}
			else if(i%3==0) {
				dp[i] = dp[i-3]+1;
			}
			else if(dp[i-3]!=0 &&dp[i-5]!=0) {
				dp[i] = Integer.min(dp[i-3], dp[i-5])+1;
			}
		}
		
		// 결과 출력 
		if(dp[N]==0) {
			System.out.println("-1");
		}
		else {
			System.out.println(dp[N]);
		}
	}
}