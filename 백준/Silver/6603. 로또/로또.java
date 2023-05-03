import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int K;
	static int[] arr;
	static int[] result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 데이터 처리 
		while (sc.hasNext()) {
			String str = sc.nextLine();
			if (str.equals("0")) {
				break;
			}
			String[] starr = str.split(" ");
			K = Integer.parseInt(starr[0]);// 주어지는 수
			arr = new int[K];
			result = new int[6];
			for (int i = 1; i <= K; i++) {
				arr[i - 1] = Integer.parseInt(starr[i]);
			}
//				System.out.println(K);
//				System.out.println(Arrays.toString(arr));
			combi(0,0);
			System.out.println();
		}
		
		


	}// main

	private static void combi(int idx, int sidx) {
		if(sidx==6) {
			for(int i=0;i<6;i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
	
		if(idx==K) {
			return;
		}
		result[sidx] = arr[idx];
		combi(idx+1,sidx+1);
		combi(idx+1,sidx);
		
	}
}