import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static boolean[] vis;
	static int min;
	static int R;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // N은 짝수 
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] = sc.nextInt();
			}
			
		}
		//System.out.println(Arrays.deepToString(map));
		vis = new boolean[N];
		min = Integer.MAX_VALUE; 
		R = N/2;
		combi(0,0);
		System.out.println(min);
		
	}// main

	private static void combi(int idx, int sidx) {
		if(sidx == R) {
			int start = 0;
			int link = 0; 
			for(int i=0;i<N;i++) {
				for(int j=i+1;j<N;j++) {
					if(vis[i] && vis[j]) {
						start += map[i][j]+map[j][i];
					}
					else if(!vis[i] && !vis[j]) {
						link += map[i][j]+map[j][i];
					}
				}	
			}
			int diff = Math.abs(start-link);
			min = Math.min(min, diff);
			return;
		}
		for(int i=idx;i<N;i++) {
			vis[i] = true;
			combi(i+1, sidx+1);
			vis[i] = false;
		}
	}
}