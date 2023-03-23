import java.util.Scanner;

public class Solution {
	static int n;// 점원의 수
	static int b;// 탑의 높이 
	static int[] all;
	static boolean[] sel; 
	static int min;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			n = sc.nextInt();
			b = sc.nextInt();
			all = new int[n];
			sel = new boolean[n];
			min = Integer.MAX_VALUE;
			// 점원들의 키가 모두 담긴 배열 
			for(int i=0; i<n;i++) {
				all[i] = sc.nextInt(); 
			}
			powerset(0);
			System.out.println("#"+test_case+" "+min);

		}

	}
	public static void powerset(int idx) {
		//base case
		if(idx == n) {
			int height = 0;
			for(int i=0;i<n;i++) {
				if(sel[i])
					height+=all[i];
				//System.out.println(height);
			}
		
			if(height>=b) {
				int tmp = height - b; 
				if(min>tmp) {
					min = tmp;
				}
			}
			return;
		}
		// recursive : 나 자신을 다시 호출하는 조건
		sel[idx] = true; 
		powerset(idx+1); 
		
		sel[idx] = false;
		powerset(idx+1);
	}
	

}