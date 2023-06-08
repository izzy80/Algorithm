import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int left = 0;
		int right = N-1;
		long ans  = 0; 
		
		//0과 음수일 경우
		while(left<right) {
			if(arr[left] < 1 && arr[left+1] <1) {
				ans+=arr[left]*arr[left+1];
			}
			else {
				break;
			}
			left+=2;
		}
		//양수일 경우 
		while(right > 0) {
			if(arr[right] > 1 && arr[right-1] > 1) {
				ans+=arr[right]*arr[right-1];
			}
			else {
				break;
			}
			right-=2;
		}
		//남은 값들
		while(right>=left) {
			ans+=arr[right];
			right--;
		}
		
		System.out.println(ans);
	}
}