import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int n=0;n<N;n++) {
			arr[n] = sc.nextInt();
		}//n for문 
		int cnt =0; 
		for(int i=N-2;i>=0;i--) {
			int back = arr[i+1];
			int front = arr[i]; 
			while(true) {
				if(back > front) break;
				else {
					front--;
					arr[i] = front;
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}

}