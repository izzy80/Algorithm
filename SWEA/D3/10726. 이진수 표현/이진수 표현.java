import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <=T;test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			String two = Integer.toBinaryString(m);
			int cnt =0;
			StringBuilder sb = new StringBuilder();
			if(two.length()<n) {
				for(int i=0;i<n-two.length();i++) {
					sb.append("0");
				}
				sb.append(two);
				two = sb.toString();
			}
		
			for(int i=two.length()-1;i>=two.length()-n;i--) {
				if(two.charAt(i)=='1') {
					cnt++;
				}
			}
			if(cnt == n) {
				System.out.println("#"+test_case+" "+"ON");
			}
			else {
				System.out.println("#"+test_case+" "+"OFF");
			}
		}
	}

}