import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			String strnum = sc.next();
			String answer = null;
			int num = Integer.parseInt(strnum.substring(strnum.length()-1));
			if(num%2==0) {
				answer = "Even";
			}
			else {
				answer = "Odd";
			}
			System.out.println("#"+tc+" "+answer);
		}//tc for문
	}//main 끝
}