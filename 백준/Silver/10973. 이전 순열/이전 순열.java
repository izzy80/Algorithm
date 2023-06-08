import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}//i for문 
		
		//이전 수열
		if(nextperm(arr)) {
			for(int i=0;i<N;i++) {
				System.out.print(arr[i]+" ");
			}
		}
		else {
			System.out.println("-1");
		}
		
	}

	private static boolean nextperm(int[] arr) {
		int i = arr.length-1;
		while(i>0 && arr[i-1] <= arr[i]) {
			i -= 1;
		}
		
		if(i <= 0) {
			return false;
		}
		int j = arr.length-1;
		while(arr[j] >= arr[i-1]) {
			j -= 1;
		}
		swap(arr, i-1, j);
		
		j = arr.length-1;
		while(i<j) {
			swap(arr,i,j);
			i+=1;
			j-=1;
		}
		return true;
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
	}
}