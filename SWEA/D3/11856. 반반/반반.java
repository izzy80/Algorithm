import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			String str = sc.next();
			String answer = "Yes";
			int[] arr = new int[91];
			
			for(int i=0;i<4;i++) {
				arr[str.charAt(i)]++;
			}
			
			
			for(int i=65;i<=90;i++) {
				if(arr[i]==1||arr[i]==4) {
					answer = "No";
					break;
				}
			}
			System.out.println("#"+tc+" "+answer);
		}//tc for문
	}//main 끝
}