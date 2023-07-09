import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 
	 * 두 나라가 공유하는 국경선을 하루 동안 연다. 
	 * 
	 * 출력 
	 * 인구 이동이 며칠 동안 발생하는 가? 
	 */
	static int N, L, R; 
	static int[][] A;
	static final int[][] move = {{0,1},{0,-1},{-1,0},{1,0}};
	static boolean[][] visited; 
	
	static class Location{
		int r;
		int c;
		
		public Location(int r, int c) {
			this.r = r; 
			this.c = c; 
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		//입력 
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		A = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " "); 
			
			for(int j=0; j< N;j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//계산 
		int ans = 0; //인구 이동 횟수 
		boolean flag = true; //반복문 탈출 flag 
		
		while(flag) {
			if(movePeople() == 0) {
				//더 이상 인구 이동을 할 수가 없으면 반복 종료 
				flag = false;
			}
			else {
				ans++; 
			}
		}
		System.out.println(ans);
	}//main

	private static int movePeople() {
		int unionCount = 0; 
		
		for(int r = 0; r < N;r++) {
			for(int c =0; c <N; c++) {
				if(!visited[r][c]) {
					Queue<Location> q = new LinkedList<>();
					Location location = new Location(r,c);
					q.add(location);
					
					List<Location> list = new ArrayList<>();
					list.add(location);
					
					visited[location.r][location.c] = true;
					int unionSum = A[location.r][location.c];
					
					while(!q.isEmpty()) {
						Location cur = q.poll();
						for(int m = 0;m<4;m++) {
							int nr = cur.r + move[m][0];
							int nc = cur.c + move[m][1];
							
							if(nr < 0 || nc <0 || nr >= N || nc >= N) continue;
							if(!visited[nr][nc] && checkBoundary(cur.r, cur.c, nr,nc)) {
								q.add(new Location(nr,nc));
								list.add(new Location(nr,nc));
								visited[nr][nc] = true;
								unionCount++;
								unionSum += A[nr][nc];
							}
						}
					}
					if(unionCount > 0) {
						int aver = unionSum / list.size();
						
						for(int i=0; i<list.size();i++) {
							Location cur = list.get(i);
							A[cur.r][cur.c] = aver;
						}
					}
				}
			}
		}
		for(int i=0;i<N;i++) {
			Arrays.fill(visited[i], false);
		}
		return unionCount;
	}

	private static boolean checkBoundary(int cr, int cc, int nr, int nc) {
		int sub = Math.abs(A[cr][cc] - A[nr][nc]);
		
		if(sub >= L && sub <= R) {
			return true;
		}
		return false;
	}
}