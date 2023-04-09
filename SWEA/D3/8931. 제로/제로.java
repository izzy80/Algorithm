import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int k=sc.nextInt();
			Stack<Integer> st = new Stack<>();
			for(int i=0;i<k;i++) {
				int num = sc.nextInt();
				if(st.isEmpty()) { // 비어있으면 일단 집어넣음
					st.push(num);
				}
				else {//안 비어있으면 
					if(num==0) {
						st.pop();
					}
					else {
						st.push(num);
					}
					
				}
			}
			//System.out.println(st.toString());
			int sum =0;
			while(!st.isEmpty()) {
				sum+=st.pop();
			}
			System.out.println("#"+tc+" "+sum);
			
		} // tc for문
	}// main 끝

}