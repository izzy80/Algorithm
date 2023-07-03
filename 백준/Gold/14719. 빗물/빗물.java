import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int[] arr = new int[W];
		for(int i=0;i<W;i++) {
			arr[i] = sc.nextInt();
		}
		
		int sum =0;
		
		for(int i=1;i<arr.length-1;i++) {
			int left = 0; 
			int right = 0;
			 
			for(int j=0;j<i;j++) {//왼쪽 최대벽 높이 탐색 
				left = Math.max(arr[j], left);
			}
			
			for(int j=i+1;j<arr.length;j++) { //오른쪽 최대벽 높이 탐색 
				right = Math.max(arr[j], right);
			}
	
			if(arr[i] < left && arr[i] < right) {//현재가 왼쪽 벽과 오른쪽 벽보다 작을 때 
				sum += Math.min(left, right) - arr[i];
			}
		}
		System.out.println(sum);
	}//main 
}