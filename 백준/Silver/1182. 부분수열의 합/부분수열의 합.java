import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N,S;
	static int answer;
	static int[] numbers;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정수의 개수
		S = sc.nextInt(); // 수열의 원소를 다 더한 값
		
		numbers = new int[N];
		for(int i=0;i<N;i++) {
			numbers[i] = sc.nextInt();
		}
		// 정렬
		Arrays.sort(numbers);
		
		// 초기화
		answer = 0;
		visited = new boolean[N];
		
		// 부분조합 돌리기
		powerset(0);
		
		
		System.out.println(answer);
	}
	private static void powerset(int idx) {
		if(idx==N) {
			int sum =0; 
			int cnt =0; // 공집합 제거 
			for(int i=0;i<N;i++) {
				if(visited[i]) {
					sum+=numbers[i];
					cnt++;
				}
			}
			if(cnt!=0 && sum==S) {
				//System.out.println(Arrays.toString(visited));
				answer++;
			}
			return;
		}
		visited[idx] = true;
		powerset(idx+1);
		visited[idx] = false;
		powerset(idx+1);
		
	}

}