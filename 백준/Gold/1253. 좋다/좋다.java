import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int left = 0;
			int right = N - 1;
			while (true) {
				if (left == i)
					left++;
				else if (right == i)
					right--;

				if (left >= right)//결과값이 없는 경우 
					break;

				if (arr[left] + arr[right] > arr[i])
					right--;
				else if (arr[left] + arr[right] < arr[i])
					left++;
				else { 
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}

}