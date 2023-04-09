import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			String str = sc.next();
			int cnt =0;
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='x') {
					cnt++;
				}
			}
			String answer = null;
			if(cnt>=8) {
				answer ="NO";
			}
			else {
				answer = "YES";
			}
			System.out.println("#"+tc+" "+answer);
		}//tc for문
	}//main 끝
}
