import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		long[] card = new long[n];
		for(int i=0;i<n;i++) {
			card[i] = sc.nextInt();
		}
		while(m>0) {
			Arrays.sort(card);
			long sum = card[0]+card[1];
			card[0] = sum;
			card[1] = sum;
			m--;
		}
		long ans =0;
		for(int i=0;i<n;i++) {
			ans += card[i];
		}
		System.out.println(ans);
		
	}
}