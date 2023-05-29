import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc =0; tc<T;tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt(); 
			int[] A = new int[N];
			int[] B = new int[M];
			for(int i=0;i<N;i++) {
				A[i] = sc.nextInt();
			}
			for(int i=0;i<M;i++) {
				B[i] = sc.nextInt();
			}
			Arrays.sort(A);
			Arrays.sort(B);
			int cnt = 0; 
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(A[i]>B[j]) {
						cnt++;
					}
					else {
						break;
					}
				}
			}
			
			//결과 출력 
			System.out.println(cnt);
		}//tc for문 	
	}//main
}