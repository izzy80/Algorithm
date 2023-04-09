import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int a = sc.nextInt(); //현미빵 가격
			int b = sc.nextInt(); //단호박빵 가격
			int c = sc.nextInt(); //현재 은비의 돈
			// 빵 상관없이 많이 사고싶음!!
			int cnt =0; 
			if(a>b) {//a가 b보다 큼
				cnt+=c/b;
			}
			else {
				cnt+=c/a;
			}
			System.out.println("#"+tc+" "+cnt);
			
			
			
					
		}//tc for문
	}//main 끝
}