import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			String str = sc.next();
			char[] ch = str.toCharArray();
			StringBuilder sb = new StringBuilder();
			for(int i=ch.length-1;i>=0;i--) {
				if(ch[i]=='b') {
					sb.append('d');
				}
				else if(ch[i]=='d') {
					sb.append('b');
				}
				else if(ch[i]=='p') {
					sb.append('q');
				}
				else{
					sb.append('p');
				}
			}
			System.out.println("#"+tc+" "+sb.toString());
		}//tc for문
	}//main

}