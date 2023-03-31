import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10; // tc 
		for(int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			String str = sc.next();
			Stack<Integer> st = new Stack<>(); 
			for(int i=0; i< n;i++) {
				int s = str.charAt(i) - '0';
				if(st.isEmpty()) {
					st.push(s);
				}
				else {//안 비어있다면
					if(s == st.peek()) { // 들어온 숫자와 꼭대기 숫자랑 같으면 빼기 
						st.pop();
					}
					else {
						st.push(s);
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			while(!st.isEmpty()) {
				sb.append(st.pop());
			}
			// 결과 출력 
			System.out.print("#"+test_case+" ");
			for(int i=sb.length()-1;i>=0;i--) {
				System.out.print(sb.charAt(i));
			}
			System.out.println();
		}
		
	}
}