import java.util.Scanner;

public class Main {
	static int[] arr;
	static Integer[] dp;
	static int max; 
	public static void main(String[] args) {
		//입력 
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		dp = new Integer[N];
		arr = new int[N];
		for(int i=0; i<N;i++) {
			arr[i] = sc.nextInt();
		}
		//초기화 
		dp[0] = arr[0];
		max = arr[0];
		
		recur(N-1);
		
		//출력 
		System.out.println(max);
	}//main
	
	private static int recur(int N) {
		if(dp[N] == null) {
			dp[N] = Math.max(recur(N - 1) + arr[N], arr[N]);
 
			max = Math.max(dp[N], max);
		}
		return dp[N];
	}
}