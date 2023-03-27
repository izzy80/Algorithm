import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int n;
	static boolean[] visited;
	static int[] result;
	static int min;
	static int cx,cy,hx,hy;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1;test_case<=T;test_case++) {
			n = sc.nextInt(); // N명의 고객을 방문
			// 회사의 좌표
			cx = sc.nextInt();
			cy = sc.nextInt();
			
			// 집의 좌표
			hx = sc.nextInt();
			hy = sc.nextInt();
			
			// 고객의 좌표
			map = new int[n][2];
			for(int i=0;i<n;i++) {
				for(int j=0;j<2;j++) {
					map[i][j] = sc.nextInt();
					
				}
			}
			//System.out.println(Arrays.deepToString(map));
			
			// 
			visited = new boolean[n];
			result = new int[n];
			min = Integer.MAX_VALUE;
			
			perm(0);
			System.out.println("#"+test_case+" "+min);
			
		}
	}

	public static void perm(int idx) {
		if(idx==n) {
			//System.out.println(Arrays.toString(result));
			int total = 0;
			// 회사 - 첫 번째 
			total += Math.abs(cx-map[result[0]][0]);
			total += Math.abs(cy-map[result[0]][1]);
			for(int i=0;i<result.length-1;i++) {
				total += Math.abs(map[result[i]][0]-map[result[i+1]][0]);
				total += Math.abs(map[result[i]][1]-map[result[i+1]][1]);
				
			}
			// 마지막 -> 집
			total += Math.abs(hx-map[result[n-1]][0]);
			total += Math.abs(hy-map[result[n-1]][1]);
			// 최단
			if(min>total) {
				min = total;
			}
			
			return;
		}
		for(int i=0;i<n;i++) {
			if(visited[i]) continue;
			result[idx] = i;
			visited[i] = true;
			perm(idx+1);
			visited[i] = false;
		}
		
		
	}

}