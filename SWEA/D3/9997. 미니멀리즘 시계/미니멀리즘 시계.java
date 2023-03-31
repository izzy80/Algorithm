import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1;test_case <=T;test_case++) {
			int n = sc.nextInt();
			int hour = (2*n)/60;
			int min = (2*n)%60; 
			
			System.out.println("#"+test_case+" "+hour+" "+min);
		}
	
	}

}