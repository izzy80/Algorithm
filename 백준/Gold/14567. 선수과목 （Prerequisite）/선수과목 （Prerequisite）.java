import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
	static int V;
	static int[][] map;
	static int[] in_degree;
	static Queue<Integer> q;
	static StringBuilder sb;
	static int[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt(); // 정점
		int E = sc.nextInt(); // 간선
		map = new int[V + 1][V + 1];
		in_degree = new int[V + 1]; // 진입차수

		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			// System.out.println(st);
			int ed = sc.nextInt();
			map[st][ed]++;
			in_degree[ed]++;
		}

		q = new LinkedList<>();
		sb = new StringBuilder();
		result = new int[V + 1];
		sort();

		for (int i = 1; i <= V; i++) {
			System.out.print(result[i] + " ");
		}
	}

	private static void sort() {
		int cnt = 1;
		for (int i = 1; i <= V; i++) {
			if (in_degree[i] == 0) {
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			int size = q.size();
			while(size--!=0) {
				int node = q.poll();
				result[node] = cnt;
				for (int i = 1; i <= V; i++) {
					if (map[node][i] != 0) { // 인접한 정점 꺼내기
						in_degree[i] -= 1;
						if (in_degree[i] == 0) {
							q.offer(i);
						}

					}
				}
			}
			cnt++;
		}

	}
}