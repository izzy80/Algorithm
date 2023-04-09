import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			String str = sc.next();
			int[] num = new int[10];
			for(int i=0;i<str.length();i++) {
				num[str.charAt(i)-'0']++;
			}
			int cnt =0; 
			for(int i=0;i<num.length;i++) {
				if(num[i]%2!=0) {
					cnt+=num[i]%2;
				}
			}
			System.out.println("#"+test_case+" "+cnt);
		}//test_case for문
	}//main 끝
}