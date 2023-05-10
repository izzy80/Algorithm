import java.util.Scanner;

public class Main {
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String x = sc.next(); //x의 범위는1,000,000자리 이하의 수이기 때문에 int범위를 벗어날 수 있음 
		cnt =0;
		run(x);
			
	}

	private static void run(String x) {
		if(x.length()==1) {
			System.out.println(cnt);
			int answer = Integer.parseInt(x);
			if(answer==3||answer==6||answer==9) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
		else {
			int sum =0; 
			for(int i=0;i<x.length();i++) {
				sum+= x.charAt(i)-'0';
			}
			cnt++;
			run(Integer.toString(sum));
		}
		
	}
	
}