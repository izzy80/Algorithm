import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int N,M;
	static int[][] map;
	static int[][] dist;
	static boolean[][] checked;
	static int[][] move = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};//오,하 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dist = new int[N][M];
		checked = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 2) {
					BFS(i,j);
					break;
				}
			}
		}
		
		// 출력 
		for(int i=0; i<N;i++) {
			for(int j=0;j<M;j++) {
				if(checked[i][j] == false && map[i][j] == 1) {
					// 원래 갈 수 있었는데, 갈 수 없는 땅 -1로 바꾸기 
					// == 1 꼭 넣어주기, 안 넣으면 탈 
					dist[i][j] = -1;
					System.out.print(dist[i][j]+" ");
				}
				else {
					System.out.print(dist[i][j]+" ");
				}
			}
			System.out.println();
		}
	}//main 

	private static void BFS(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		checked[r][c] = true;
		q.add(new int[] {r,c});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for(int i=0;i<move.length;i++) {
				int nr = cr+move[i][0];
				int nc = cc+move[i][1];
				
				if(nr <0 || nr >= N || nc <0 || nc >= M || checked[nr][nc])
					continue;
				if(map[nr][nc] == 0) {
					dist[nr][nc] = 0;
					checked[nr][nc] = true;
				}
				else if(map[nr][nc] == 1) {
					dist[nr][nc] = dist[cr][cc]+1;
					checked[nr][nc] = true; 
					q.add(new int[] {nr,nc});
				}
			}
		}
		
	}

}