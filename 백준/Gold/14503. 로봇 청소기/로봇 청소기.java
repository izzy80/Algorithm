import java.util.Scanner;

public class Main {
	static int N,M;
	static int room[][];
	static int cnt =0; 
	static int dr[] = {-1,0,1,0}; //북동남서
	static int dc[] = {0,1,0,-1};
	public static void main(String[] args) {
		//입력 
		Scanner sc  = new Scanner(System.in);
		N = sc.nextInt(); //방 크기 : 행
		M = sc.nextInt(); //방 크기 : 열 
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt(); 
		
		room = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				room[i][j] = sc.nextInt();
			}
		}
		
		clean(r,c,d);
		
		//출력
		System.out.println(cnt);
	}//main
	private static void clean(int row, int col, int direction) {
		// 1. 현재 위치 청소 유무
		if(room[row][col] ==0) {//청소 안 했다면
			room[row][col] = 2;
			cnt++;
		}
		
		//2. 왼쪽방향부터 탐색 
		boolean flag = false;
		int origin = direction;
		for(int i=0;i<4;i++) {
			int nd = (direction+3)%4;
			int nr = row + dr[nd];
			int nc = col + dc[nd];
			
			if(nr > 0 && nc >0 && nr < N && nc <M) {
				if(room[nr][nc] ==0) {//청소 안 했다면
					clean(nr, nc, nd);
					flag = true;
					break;
				}
			}
			direction = (direction + 3)%4;
		}
		
		//네 방향 모두 청소되었거나 벽인 경우 
		if(!flag) {
			int nd = (origin+2)%4;
			int nbr = row + dr[nd];
			int nbc = col+dc[nd];
			
			if(nbr > 0 && nbr > 0 && nbr < N && nbc <M) {
				if(room[nbr][nbc]!=1) {
					clean(nbr, nbc, origin); //바라보는 방향 유지한채 후진
				}
			}
		}
		
	}
}