import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case<=T;test_case++) {
			int max = Integer.MIN_VALUE;
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] map = new int[n][m];
			int[] score = new int[n];
			for(int i=0;i<n;i++) {
				//int sum = 0; 
				for(int j=0;j<m;j++) {
					map[i][j] = sc.nextInt();
					score[i]+=map[i][j];
				}
				if(score[i]>max) {
					max = score[i];
				}
			
			}
			
			int cnt = 0; 
			for(int i=0;i<n;i++) {
				if(max == score[i]) {
					cnt++;
				}
			}
			
			// 출력 
			System.out.println("#"+test_case+" "+cnt+" "+max);
		}// test_case for문

	}

}