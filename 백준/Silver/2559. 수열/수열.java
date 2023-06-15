import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //온도를 측정한 전체 날짜의 수 
		int K = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		int st = 0;
		int ed = K-1;
		int max = Integer.MIN_VALUE;
		while(ed < arr.length) {
			int sum = 0; 
			for(int i=st;i<=ed;i++) {
				sum += arr[i];
			}
			if(max < sum) {
				max = sum;
			}
			st++;
			ed++;
		}
		System.out.println(max);
		
	}
}