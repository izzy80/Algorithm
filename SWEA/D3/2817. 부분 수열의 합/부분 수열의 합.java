import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case =1;test_case<=T;test_case++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			// 비트
			int sum = 0; 
			int cnt = 0;
			for(int i=0;i<(1<<n);i++) {
				for(int j=0;j<n;j++) {
					if((i & (1<<j))>0) {
						sum +=arr[j];
					}
				}
				if(sum == k) {
					cnt++;
				}
				sum = 0; 
			}
			System.out.println("#"+test_case+" "+cnt);
		}
	}

}