import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1;tc<=T;tc++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			int answer = 0;
			for(int i=0;i<arr.length-1;i++) {
				if(arr[i]>arr[i+1]) {
					answer+=arr[i];
				}
				else if(arr[i]<arr[i+1]) {
					answer+=arr[i+1];
				}
				else {
					answer+=arr[i+1];
				}
			}
			answer+=arr[0]+arr[arr.length-1]+n;
			System.out.println("#"+tc+" "+answer);
		}
	}
}