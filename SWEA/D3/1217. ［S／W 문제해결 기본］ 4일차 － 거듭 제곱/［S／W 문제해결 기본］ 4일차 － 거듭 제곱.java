import java.util.Scanner;

public class Solution {
	static int n;
	static int m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int test_case = 1; test_case<=T;test_case++) {
			int tc = sc.nextInt();
			n = sc.nextInt();
			m = sc.nextInt();
			
			System.out.println("#"+test_case+" "+pow_recur(n,m));
		}
	}
	private static int pow_recur(int n, int m) {
		if(m==1) {
			return n;
		}
		return n*pow_recur(n, m-1);
	}

}