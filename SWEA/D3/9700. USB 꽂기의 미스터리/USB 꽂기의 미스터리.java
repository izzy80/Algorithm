import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			Double p = sc.nextDouble();
			Double q = sc.nextDouble();
			String answer = null;
			
			Double s1 = (1-p)*q;
			Double s2 = p*(1-q)*q;
			if(s1<s2) {
				answer = "YES";
			}
			else {
				answer = "NO";
			}
			
			System.out.println("#"+tc+" "+answer);
		}//tc for문
	}//main 끝
}