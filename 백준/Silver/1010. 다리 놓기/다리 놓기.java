import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=0;tc<T;tc++) {
			int N =sc.nextInt(); // 서쪽 
			int M = sc.nextInt(); // 동쪽 
		
			int answer = 1;
			for(int i=1;i<=N;i++) {
				answer*=M;
				answer/=i;
				M--;
			}
			System.out.println(answer);
			
			
		}
	}
}