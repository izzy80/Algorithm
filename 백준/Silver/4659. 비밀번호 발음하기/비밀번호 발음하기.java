import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		while(sc.hasNext()) {
			boolean first = false;
			boolean second = true;
			boolean third = true;
			
			String str = sc.next();
			// 입력 종료 
			if(str.equals("end")) {
				break;
			}
			if(str.contains("a")||str.contains("e")
					||str.contains("i")||str.contains("o")
					||str.contains("u")) {
				first = true; 
			}

			if(str.length()==1) {//1자리이면
			}
			else {
				if(str.length()>2) {
					// 두 번째 
					int s = 0; 
					int e = 3;
					while(e <= str.length()) {
						int mo = 0;
						int ja = 0; 
						for(int i=s;i<e;i++) {
							if(str.charAt(i)=='a'||str.charAt(i)=='e'
									||str.charAt(i)=='i'||str.charAt(i)=='o'
									||str.charAt(i)=='u') {
								mo++;
							}
							else {
								ja++;
							}
						}
						if(mo==3||ja==3) {
							second = false;
						}
						s++;
						e++;
					}
				}
				// 세 번째 
				int st = 0;
				int ed = 1;
				while(ed<str.length()) {
					if(str.charAt(st)==str.charAt(ed)) {
						if(str.charAt(st)=='e' || str.charAt(st)=='o') {
							third = true;
						}
						else {
							third = false;
						}
						break;
					}
					st++;
					ed++;
				}
			}
//			System.out.println(first);
//			System.out.println(second);
//			System.out.println(third);
			if(!first || !second ||!third) {
				System.out.println("<"+str+"> is not acceptable.");
			}
			else {
				System.out.println("<"+str+"> is acceptable.");
			}
			
		}//while
	}//main
}