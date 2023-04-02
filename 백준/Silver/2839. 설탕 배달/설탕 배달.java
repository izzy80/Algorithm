import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 배달해야할 설탕
		// 3킬로, 5킬로 봉지 존재
		// 최대한 적은 봉지 가져가고 싶어함. 
	
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<=1000;i++) {
			for(int j=0;j<=16667;j++) {
				if(i*3+j*5 == n) {
					q.offer(i);
					q.offer(j);
				}
			}
		}
		//System.out.println(q);
		int arrn = q.size();
		
		if(q.isEmpty()) { // 비어있으면 맞는게 없다는 것이므로
			System.out.println(-1);
		}
		else{
			int[][] arr = new int[arrn/2][2];
			int nn = 0; 
			while(!q.isEmpty()) {
				arr[nn][0] = q.poll();
				arr[nn][1] = q.poll();
				nn++;
			}
			//System.out.println(Arrays.deepToString(arr));
			int sum = 0;
			int min = Integer.MAX_VALUE;
			for(int i=0; i<arr.length;i++) {
				sum +=arr[i][0]+arr[i][1];
				if(min>sum) {
					min = sum;
				}
			}
			System.out.println(min);
		}
		
		
		
	}
}