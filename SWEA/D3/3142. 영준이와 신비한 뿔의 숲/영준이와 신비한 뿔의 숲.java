import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt(); // n개의 뿔
			int m = sc.nextInt(); // m마리의 짐승
			int twin =0;
			int uni = 0; 
			for(int i=0;i<=m;i++) {
				for(int j=0; j<=m;j++) {
					if(j+(i*2) == n && j+i == m) {
						twin = i;
						uni = j;
					}
				}
			}
			System.out.println("#"+tc+" "+uni+" "+twin);
				
			
			
		}//tc for문
	}//main 끝
}