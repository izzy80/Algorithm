import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			
			int cover = (2*d)+1;
			int cnt =0; 
			cnt = n/cover;
			int mod = n%cover;
			if(mod>0) {
				cnt++;
			}
			System.out.println("#"+tc+" "+cnt);
		}//tc for문
	}//main 끝

}
