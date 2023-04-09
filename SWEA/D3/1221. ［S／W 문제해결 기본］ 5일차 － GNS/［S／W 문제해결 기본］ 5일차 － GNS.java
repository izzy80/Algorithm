import java.util.Arrays;
import java.util.Scanner;

public class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int tc=1;tc<=T;tc++) {
			String str = sc.nextLine();
			String[] strrr = str.split(" ");
			int num = Integer.parseInt(strrr[1]);
			
			String[] str1 = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
			String[] call = sc.nextLine().split(" ");
			System.out.println("#"+tc);
			for(int i=0;i<10;i++) {
				for(int j=0;j<num;j++) {
					if(call[j].equals(str1[i])) {
						System.out.print(call[j]+" ");
					}
				}
			}
		}//tc for문
	}//main 끝
}
