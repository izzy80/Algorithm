import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			System.out.println("#"+tc+" "+(int)Math.pow(N, 2));
		}//tc for문
	}//main 끝
}