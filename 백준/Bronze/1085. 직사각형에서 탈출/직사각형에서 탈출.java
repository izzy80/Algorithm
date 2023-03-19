import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt(); // 한수의 x 위치
		int y = sc.nextInt(); // 한수의 y 위치
		int[] arrx = new int[2];
		arrx[1] = sc.nextInt();
		int[] arry = new int[2];
		arry[1] = sc.nextInt();
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < 2; i++) {
			int xdiff = Math.abs(x - arrx[i]);
			if (min > xdiff) {
				min = xdiff;
			}

		}

		for (int i = 0; i < 2; i++) {
			int ydiff = Math.abs(y - arry[i]);
			if (min > ydiff) {
				min = ydiff;
			}

		}
		System.out.println(min);

	}
}