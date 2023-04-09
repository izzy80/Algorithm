import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			String str = sc.next();
			int a = 1;
			int b = 1;
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='L') {
					b=a+b;
				}
				else {//R
					a = a+b;
				}
			}
			System.out.println("#"+test_case+" "+a+" "+b);
		}//test_case for문
	}//main 끝
}