import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			// 1. 값 집어넣기 
			// 1-1. 이용권 요금
			int[] money = new int[4];
			for(int i=0;i<4;i++) {
				money[i] = sc.nextInt();
				// day : [0], month : [1], 3month : [2], year : [3]
			}
			//1-2. 월별 사용횟수 
			int[] month = new int[12+1];
			for(int i=1;i<=12;i++) {
				month[i] = sc.nextInt();
			}
			
			// 2. dp 테이블 만들기
			int[] dp = new int[12+1];
			dp[1] = Math.min(month[1]*money[0], money[1]);
			for(int i=2;i<=12;i++) {
				int min = Integer.MAX_VALUE;
				if(i==12) min = Math.min(min, money[3]); // 1년 이용권 사용가능
				if(i>=3)min = Math.min(min, dp[i-3]+money[2]); // 3이상부터 3month이용권 사용가능 
				if(i>=2)min = Math.min(min, dp[i-1]+money[1]);
				if(i>=2)min = Math.min(min, dp[i-1]+month[i]*money[0]);
				// 위에서부터 min 업데이트 시켜옴 
				dp[i] = min;
			}
			System.out.println("#"+tc+" "+dp[12]);
		}//tc

	}//main

}