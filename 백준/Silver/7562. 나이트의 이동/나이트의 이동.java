import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int l;
	static int[][] visited;
	static Queue<int[]> q;
	static int min = Integer.MAX_VALUE;
	static int nr,nc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			l = sc.nextInt();
			map = new int[l][l];
			int pr = sc.nextInt();
			int pc = sc.nextInt();
			nr = sc.nextInt();
			nc = sc.nextInt();

			map[pr][pc] = 1; // 출발
			q = new LinkedList<>();
			visited = new int[l][l];
			for(int i=0;i<l;i++) {
				Arrays.fill(visited[i], -1);
			}

			BFS(pr, pc);
			System.out.println(visited[nr][nc]);

		} // tc for문
	}

	private static void BFS(int pr, int pc) {
		q.add(new int[] { pr, pc });
		int[][] move = { { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 } };
		visited[pr][pc] =0; //출발지는 카운트하지 X
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			if (cr==nr && cc==nc) {
				break;
			}
			for (int i = 0; i < 8; i++) {
				int nr = cr + move[i][0];
				int nc = cc + move[i][1];
				if (nr >= 0 && nr < l && nc >= 0 && nc < l && map[nr][nc] != 1 && visited[nr][nc]==-1) {
					q.add(new int[] { nr, nc });
					visited[nr][nc] = visited[cr][cc]+1;
				}
			}
		} // while문

	}
}