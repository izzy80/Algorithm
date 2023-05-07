import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 필요한 기타줄 수 (100보다 작거나 같은 자연수)
		int M = sc.nextInt(); // 기타줄 브랜드 (50보다 작거나 같은 자연수)
		int[] pack = new int[M];
		int[] one = new int[M];
		for(int i=0;i<M;i++) {
			pack[i] = sc.nextInt(); // 패키지(6개) 가격
			one[i] = sc.nextInt(); // 1개의 가격
		}
		// 정렬
		Arrays.sort(pack);
		Arrays.sort(one);
		
		// 패키지 VS 싱글 VS 패키지+싱글 
		int answer = Integer.min(((N/6)+1)*pack[0], one[0]*N);
		answer = Integer.min(answer,(pack[0]*(N/6))+(one[0]*(N%6)));
		
		System.out.println(answer);
	}// main
}