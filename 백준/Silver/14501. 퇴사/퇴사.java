import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N일
		int[] T = new int[N+1]; // 상담시 걸리는 시간
		int[] P = new int[N+1]; // 상담시 받는 금액 
		int[] DP = new int[N+1];
		
		// 값 받기 
		for(int i=0;i<N;i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		for(int i=0;i<N;i++) {//날짜를 돌린다고 생각
			if(i+T[i]<=N) {// 선택된 날짜와 해당되는 날의 상담시간을 더해서 N 이하이면 
				DP[i+T[i]] = Math.max(DP[i+T[i]], DP[i]+P[i]);
				//기존과 새로 비용을 더한 값과 비교해서 큰 값을 집어넣기
			}
			// 선택되지 못 하면, 이전까지 일한 최대 금액을 준다. 
			DP[i+1] = Math.max(DP[i+1], DP[i]);
		}
		System.out.println(DP[N]);
		
	}
}