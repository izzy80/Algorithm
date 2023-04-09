import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int[] arr = {0,31,29,31,30,31,30,31,31,30,31,30,31};
			int m = sc.nextInt();
			int d = sc.nextInt();
			int day = 0; 
			for(int i=0;i<m;i++) {
				day+=arr[i];
			}
			day+=d;
			int num =0; 
			if(day%7==0) {
				num = 3;
			}
			else if(day%7==1) {
				num = 4;
			}
			else if(day%7==2) {
				num = 5;
			}
			else if(day%7==3) {
				num = 6;
			}
			else if(day%7==4) {
				num = 0;
			}
			else if(day%7==5) {
				num = 1;
			}
			else {
				num = 2;
			}
			System.out.println("#"+tc+" "+num);
			
		}//tc for문
	}//main 끝
}