import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, X;
	static int[] numbers;
	static int[] result;
	static int answer; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N]; // 숫자가 들어간 배열 생성 
		for(int i=0;i<N;i++) {
			numbers[i] = sc.nextInt();
		}
		Arrays.sort(numbers); // 정렬함 
		X = sc.nextInt(); // numbers에서 선택된 두 숫자가 만들어야 할 값 
		
		answer = 0; 
		
		for(int i=0; i<N-1;i++) {
			int sum =0; 
			for(int j=i+1;j<N;j++) {
				sum= numbers[i]+numbers[j];
				//System.out.println(sum);
				if(sum == X) {
					answer++;
				}
				else if(sum>X) {
					break;
				}
			}
		}
		
		System.out.println(answer);
	}
}