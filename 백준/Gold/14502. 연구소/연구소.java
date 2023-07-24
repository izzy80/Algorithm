import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 행 : N / 열 : M
 * 0 : 빈칸 / 1 : 벽 / 2 : 바이러스  
 */
public class Main {
	static int N,M;
	static int[][] map; 
	static int[][] move = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
	static int ans = Integer.MIN_VALUE; 
	static int[][] copymap;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for(int i=0; i< N; i++) {
			for(int j=0; j< M;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		DFS(0); 
		
		System.out.println(ans);
	}

	private static void DFS(int depth) {
		if(depth == 3) {
			BFS();
			return;
		}
		
		for(int i=0; i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					DFS(depth+1);
					map[i][j] = 0; 
				}
			}
		}
	}

	//바이러스 퍼뜨리기 
	private static void BFS() {
		Queue<int[]> q = new LinkedList<>();
		copymap = new int[N][M];
		
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copymap[i][j] = map[i][j];
                if (copymap[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

		while(!q.isEmpty()) {
			int[] tmp  = q.poll(); 
			
			for(int m =0; m< 4;m++) {
				int nr = tmp[0]+move[m][0];
				int nc = tmp[1]+move[m][1];
				
				if(nr <0 || nr >= N || nc <0 || nc >= M) continue;
				if(copymap[nr][nc] == 0) {
					copymap[nr][nc] = 2; 
					q.add(new int[] {nr,nc});
				}
			}
		}
		
		// 숫자 세기 
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copymap[i][j] == 0) {
                    count++;
                }
            }
        }
        ans = Math.max(ans, count);
	}
}