import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int tc=1;tc<=T;tc++) {
			StringBuilder sb = new StringBuilder(); 
			String str = sc.nextLine();
			String[] ss = str.toUpperCase().split(" ");
			for(int i=0;i<ss.length;i++) {
				char[] ch = ss[i].toCharArray();
				sb.append(ch[0]);
			}
			System.out.println("#"+tc+" "+sb.toString());
			
			
			
			
		}//tc for문
	}//main 끝
}