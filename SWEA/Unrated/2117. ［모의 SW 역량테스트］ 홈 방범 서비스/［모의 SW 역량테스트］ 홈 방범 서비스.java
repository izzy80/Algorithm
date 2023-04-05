import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N;
	static int M;
	static int[][] map;
	static int max;
	
	public static void main(String[] args) {
		/*
		 * 운영비용은 불변이다. 
		 * 홈방범 서비스를 제공받는 집들은 각각 M의 비용을 지불할 수 있어, 
		 * 보안회사에서는 손해를 보지 않는 한 최대한 많은 집에 홍방법 서비스를 제공하려고 한다. 
		 * 손해를 보지 않으면서 홈방법 서비스를 가장 많은 집들에 제공하는 서비스 영역을 찾고, 
		 * 그때의 홍방법 서비스를 제공 받는 집들의 수를 출력하라.  
		 */
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1;test_case<=T;test_case++) {
			N = sc.nextInt(); // 도시의 크기
			M = sc.nextInt(); // 하나의 집이 지불할 수 있는 비용
			map = new int[N][N];
			max = Integer.MIN_VALUE;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			//System.out.println(Arrays.deepToString(map)); // 확인
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					bomb(i,j);
					
				}
			}
			
			
		System.out.println("#"+test_case+" "+max);
		}// test_case for문
	}// main

	private static void bomb(int cenr, int cenc) {
		for(int k=1;k<=2*N-1;k++) {
			int money = k*k+(k-1)*(k-1); // 운영 비용 
			int cnt = 0; 
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(Math.abs(cenr-i)+Math.abs(cenc-j)<=k-1) {
						if(map[i][j]==1) {//범위 안에 들어가는 i,j가 1이면 집임 
							cnt++;
						}
					}
				}
			}
			int hmoney = cnt*M;// 집에서 걷는 돈
			if(hmoney-money>=0) { // 손해 보지 않는다면 
				if(max < cnt) {
					max = cnt;
				}
			}
			
		}
		
	} // method 끝 

}