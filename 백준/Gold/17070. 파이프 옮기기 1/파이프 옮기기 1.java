import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,cnt; 
	static int[][] map;  
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		cnt =0; 
		StringTokenizer st;
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				//빈칸은 0, 벽은 1 
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		//System.out.println(Arrays.deepToString(map));
		
		DFS(0,1,0);
		
		System.out.println(cnt);
	}//main

	//state = 0 가로, 1 세로, 2 대각선 
	static void DFS(int r, int c, int state) {
		if(r == N-1 && c == N-1) {
			cnt++;
			return; 
		}
		
		if(state == 0) { //가로 (0,0) -> (0,1) 
			if(c+1 < N && map[r][c+1] == 0) {
				DFS(r,c+1,0);
			}
		}
		else if(state == 1) {//세로 (0,0) -> (1,0)
			if(r+1 < N && map[r+1][c] == 0) {
				DFS(r+1,c,1);
			}
		}
		else if(state == 2) {//대각선 (0,0) -> (1,1)
			if(c+1 < N && map[r][c+1] == 0) {
				DFS(r,c+1,0);
			}
			if(r+1 < N && map[r+1][c] == 0) {
				DFS(r+1,c,1);
			}
		}
		
		if(r+1 < N && c+1 < N && map[r][c+1] == 0 
				&& map[r+1][c] ==0 && map[r+1][c+1] ==0 ) {
			DFS(r+1, c+1,2);
		}
		
	}

	
}