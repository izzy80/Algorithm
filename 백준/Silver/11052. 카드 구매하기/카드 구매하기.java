import java.util.Scanner;
/*
 * 카드의 개수가 적은 팩이더라도 가격이 비싸면 높은 등급의 카드가 많이 들어있을 것이라 생각 
 * 카드 i개가 포함된 카드팩의 가격은 Pi원 
 * 카드 N개를 갖기 위해 지불해야 하는 금액의 최대값은? 
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //구매하려고 하는 카드의 개수 
		int[] P = new int[N+1]; //index만큼 카드가 들어있고, 그 카드팩의 가격 
		for(int i=1;i<=N;i++) {
			P[i] = sc.nextInt();
		}
		int[] dp = new int[N+1];
		
		//dp
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=i;j++) {
				dp[i] = Math.max(dp[i],dp[i-j]+P[j]);
			}
		}
		
		//결과 
		System.out.println(dp[N]);
	}//main 
}