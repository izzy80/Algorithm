import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N,W,H;
	static int[][] map;
	static int[] result;
	static int[][] move = {{-1,0},{1,0},{0,-1},{0,1}}; // 상 하 좌 우 
	static int[][] copy;
	
	// bfs
	static boolean[][] visited;
	static Queue<int[]> q;
	
	static int cnt;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1;test_case<=T;test_case++) {
			N = sc.nextInt(); // 구슬 사용 횟수
			W = sc.nextInt(); // 열
			H = sc.nextInt(); // 행
			result = new int[N];
			map = new int[H][W];
			for(int i=0; i<H;i++) {
				for(int j=0; j<W;j++) {
					map[i][j] = sc.nextInt();
				}
			}
		
			q = new LinkedList<>();
			min = Integer.MAX_VALUE;
			perm(0);
			
			System.out.println("#"+test_case+" "+min);
		}// test_case for문
	}// main
	
	// 중복 순열 => 순서 중요, 중복 가능 
	private static void perm(int idx) {
		if(idx == N) {
			cnt = 0; 
			// 배열 복사본 만들기 
			copy = new int[H][W];
			for(int i=0;i<H;i++) {
				copy[i] = map[i].clone();
			}
			
			// 구슬이 가장 처음 닿는 곳 찾기
			for(int g = 0;g<N;g++) {//result 구슬 배열 돌리기 
				visited = new boolean[H][W];
				for(int i=0; i<H;i++) {
					if(copy[i][result[g]]!=0) {//구슬이 처음 닿는 곳 
						int r = i;
						int c = result[g];
						BFS(r,c);
						break;
					}
				}
				// 중력 작용시키는 메소드 작성 
				gravity();
//              문제 정답 예시               
//				if(result[0]==2&&result[1]==2&&result[2]==6)
//				System.out.println(Arrays.deepToString(copy));
			}
			// 남은 벽돌 개수 세주기 
			cnt = count();
			if(min>cnt) {
				min = cnt;
			}
			return;
		}
		for(int i=0;i<W;i++) {
			result[idx] = i;
			perm(idx+1);
		}
	}

	private static void BFS(int r, int c) {
		q.add(new int[] {r,c,copy[r][c]});
		visited[r][c] = true; 
		copy[r][c] = 0; // copy본 변경  
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			int cr = curr[0];
			int cc = curr[1];
			int cval = curr[2];

			for(int i=0;i<4;i++) {
				for(int j=0;j<cval;j++) {
					int nr = cr +move[i][0]*j;
					int nc = cc + move[i][1]*j;
					if(nr<0 ||nr >= H|| nc <0 || nc>=W || visited[nr][nc] || copy[nr][nc]==0.) continue;
					if(copy[nr][nc]!=1||copy[nr][nc]!=0) { //1이 아니거나 0이 아닐 때 
						q.add(new int[] {nr,nc,copy[nr][nc]});
						copy[nr][nc] = 0; 
						visited[nr][nc] = true;	
					}
				}//j for
			}//i for 
		}// while
	}
	
	// 중력 적용하는 메소드 
	private static void gravity() {
		for(int j=0;j<W;j++) {
			for(int i=0;i<H;i++) {
				if(copy[i][j]==0) { // 빈공간이 있다면 
					for(int k=i-1;k>=0;k--) {//임시 행
						if(map[k][j]!=0) {
							if(k+1>H) continue;
							int tmp = copy[k+1][j];
							copy[k+1][j] = copy[k][j];
							copy[k][j] = tmp;
						}
					}
				}
			}
		}
		
	}
	
	// 남은 벽돌 세주기 
	private static int count() {
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(copy[i][j]!=0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

}