import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //이미 심어져 있는 가로수의 수 
		int[] arr = new int[N]; //심어진 가로수의 위치 
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		//정렬(오름차순) 
		Arrays.sort(arr);
		
		//가로수 간의 거리 구하기
		//거리간의 최대공약수 구하기 
		int gcd = 0; //최대공약수 
		for(int i=0;i<N-1;i++) {
			int gap = arr[i+1]-arr[i];
			gcd = GCD(gap, gcd);
		}
		
		//추가로 필요한 가로수의 개수
		int answer =  ((arr[N-1] - arr[0])/gcd+1)-(arr.length);
		System.out.println(answer);
	}//main 

	static int GCD(int gap, int gcd) {
		if(gcd==0) {
			return gap;
		}
		else {
			return GCD(gcd, gap%gcd);
		}
	}
}