import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			int sum =0; 
			for(int i=arr.length-1;i>=arr.length-k;i--) {
				sum+=arr[i];
			}
			System.out.println("#"+tc+" "+sum);
		}//tc for문
	}//main 끝
}