import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];

		int max = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]);
			sum += arr[i];
		}

		System.out.println(binSearch(max, sum));
	}

	public static int binSearch(int left, int right) {

		int pl = left;
		int pr = right;

		do {

			int pc = (pl + pr) / 2;
			int cnt = 1;
			int money = pc;
			for (int i = 0; i < N; i++) {
				if (arr[i] > money) {
					money = pc;
					cnt++;
				}
				money = money - arr[i];
			}

			if (cnt > M)
				pl = pc + 1;
			else
				pr = pc - 1;

		} while (pl <= pr);

		return pl;
	}

}