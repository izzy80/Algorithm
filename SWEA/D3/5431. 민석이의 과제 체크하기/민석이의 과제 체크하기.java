import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case<=T;test_case++) {
			int n = sc.nextInt();
			int[] arr = new int[n+1];
			int m = sc.nextInt();
			for(int i=0;i<m;i++) {
				arr[sc.nextInt()]++;
			}
			System.out.print("#"+test_case+" ");
			for(int i=1; i<arr.length;i++) {
				if(arr[i]==0) {
					System.out.print(i+" ");
				}
			}
			System.out.println();
		}
	}

}