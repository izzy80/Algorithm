import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int m = sc.nextInt();
		for(int i =0; i<m;i++) {
			int find = sc.nextInt(); // 찾아야할 숫자 
			if(Arrays.binarySearch(arr, find)<0) {
				System.out.println(0);
			}
			else {
				System.out.println(1);
			}
			
		}
	}
}