import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int max = 0; 
			int min = 0; 
			if(a+b<n) {
				if(a>b) {
					max = b;
				}else {
					max = a;
				}
			}
			else {
				if(a>b) {
					max = b;
				}
				else {
					max = a; 
				}
				min = (a+b)-n;
			}
			System.out.println("#"+tc+" "+max+" "+min);
			
			
			
		}//tc for문
	}//main 끝
}