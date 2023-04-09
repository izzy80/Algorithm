import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();				
			}
			
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int cnt = 0; 
			for(int i=1;i<n-1;i++) {
				int idx =0; 
				int[] arr2 = new int[3];
				for(int j=-1;j<2;j++) {
					arr2[idx] = arr[i+j];
					idx++;
				}
				if((arr2[0]<arr2[1]&&arr2[1]<arr2[2])||(arr2[0]>arr2[1]&&arr2[1]>arr2[2])) {
					cnt++;
				}
			}
			System.out.println("#"+tc+" "+cnt);
					
		} // tc for문
	}// main 끝

}