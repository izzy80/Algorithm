import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		dp[1] = 1;
		if(n>=2) {
			dp[2] = 2;
		}
		for(int i=3;i<=n;i++) {
			dp[i] = (dp[i-2]+dp[i-1])%10007; // int 범위 넘어가서 미리 나누어줌
		}
		
		int mod = dp[n]%10007;
		System.out.println(mod);
	}
}