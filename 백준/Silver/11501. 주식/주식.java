import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트케이스의 수 
		for(int tc=0;tc<T;tc++) {
			int N = sc.nextInt(); //날의 수를 나타내는 자연수
			long[] stock = new long[N];
			for(int i=0;i<N;i++) {
				stock[i] = sc.nextInt(); //날 별 주가 
			}
		long max = 0; 
		long ans = 0; 
		for(int i=stock.length-1;i>=0;i--) { //뒤에서부터 내려오기 
			if(stock[i]>max) {
				max = stock[i];
			}
			else {
				ans+=(max-stock[i]);
			}
		}
		System.out.println(ans);	
		}// tc
	}
}