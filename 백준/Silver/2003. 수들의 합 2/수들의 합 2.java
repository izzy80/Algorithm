import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		long M = sc.nextInt();
		int[] A = new int[N];
		for(int i=0;i<N;i++) {
			A[i] = sc.nextInt();
		}
		int cnt =0; 
		for(int p1=0;p1<N;p1++) {
			long sum = 0; 
			for(int p2=p1;p2<N;p2++) {
				sum+=A[p2];
				if(sum==M) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}

}