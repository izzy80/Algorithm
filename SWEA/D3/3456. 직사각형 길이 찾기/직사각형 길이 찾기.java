import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <=T;tc++) {
			int arr[] = new int[101];
			for(int i=0;i<3;i++) {
				arr[sc.nextInt()]++;
			}
			// 직사각형 길이 찾기
			for(int i=1;i<=100;i++) {
				if(arr[i]==1||arr[i]==3) {
					System.out.println("#"+tc+" "+i);
				}
			}
			
		}//tc

	}//main

}