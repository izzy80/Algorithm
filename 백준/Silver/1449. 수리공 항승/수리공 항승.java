import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//입력 
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //물의 새는 곳의 개수 
		int L = sc.nextInt(); //테이프의 길이 
		int[] arr = new int[N]; //물이 새는 곳의 위치
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int range = (int)(arr[0]-0.5+L);
		int count = 1; 
		
		for(int i=1;i<arr.length;i++) {
			if(range < (int)(arr[i]+0.5)) {
				range = (int)(arr[i]-0.5+L);
				count++;
			}
		}
		System.out.println(count);
		
		
		
		
	}
}