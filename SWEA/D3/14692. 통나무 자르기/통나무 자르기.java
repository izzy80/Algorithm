import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			String answer = null;
			if(n%2==0) {
				answer = "Alice";
			}
			else {
				answer = "Bob";
			}
			System.out.println("#"+tc+" "+answer);	
		}//tc for문
	}//main 끝
}