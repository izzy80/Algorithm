import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1;test_case<=T;test_case++) {
			String str = sc.next();
			int answer = 0; 
			if(str.equals("SUN")) {
				answer = 7; 
			}
			else if(str.equals("MON")) {
				answer = 6; 
			}
			else if(str.equals("TUE")) {
				answer = 5; 
			}
			else if(str.equals("WED")) {
				answer = 4; 
			}
			else if(str.equals("THU")) {
				answer = 3; 
			}
			else if(str.equals("FRI")) {
				answer = 2; 
			}
			else {
				answer = 1; 
			}
			
			System.out.println("#"+test_case+" "+answer);
			
		}
	}

}