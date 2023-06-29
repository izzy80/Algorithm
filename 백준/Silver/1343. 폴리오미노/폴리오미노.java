import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		int x_cnt = 0;
		int l = str.length(); //문자열의 길이 
		StringBuilder sb = new StringBuilder(); 
		String A = "AAAA";
		String B = "BB";
		
		String answer = "0";
		for(int i=0;i<l;i++) {
			char tmp = str.charAt(i);
			if(tmp == 'X') {
				x_cnt++; 
			}
			else {//tmp가 .이면 
				if(x_cnt%4==0) {
					for(int j=0;j<x_cnt/4;j++) {
						sb.append(A);
					}
				}
				else if(x_cnt%4==2) {
					for(int j=0;j<x_cnt/4;j++) {
						sb.append(A);
					}
					sb.append(B);
				}
				else {
					answer = "-1";
					break;
				}
				sb.append(".");
				//초기화 
				x_cnt = 0; 
			}
		}
		if(x_cnt%4==0) {
			for(int j=0;j<x_cnt/4;j++) {
				sb.append(A);
			}
		}
		else if(x_cnt%4==2) {
			for(int j=0;j<x_cnt/4;j++) {
				sb.append(A);
			}
			sb.append(B);
		}
		else {
			answer = "-1";
		}
		
		if(answer.equals("-1")) {
			System.out.println(answer);
		}
		else {
			System.out.println(sb.toString());
		}
		
		
		
		
	}//main
}