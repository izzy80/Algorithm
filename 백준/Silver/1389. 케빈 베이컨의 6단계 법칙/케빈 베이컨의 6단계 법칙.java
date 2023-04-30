import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,M;
	static int[][] map;
	
	static Queue<Integer> q;
	static int sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 유저의 수
		M = sc.nextInt(); // 친구 관계의 수 
		map = new int[N+1][N+1];
		for(int i=0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		
		q = new LinkedList<>();
		int min = Integer.MAX_VALUE;
		int answer = 0;	
		
		for(int i=1;i<=N;i++) {
			sum =0; 
			BFS(i);
			if(min>sum) {
				min = sum;
				answer = i;
			}
			
		}
		
		System.out.println(answer);
		
	}
	private static void BFS(int v) {
		boolean[] visited = new boolean[N+1];
		int[] dist = new int[N+1];
		
		q.add(v);
		visited[v] = true;

		while(!q.isEmpty()) {
			int curr = q.poll();

			for(int i=1;i<=N;i++) {
				if(!visited[i] && map[curr][i] == 1) {
					q.add(i);
					visited[i] = true;
					dist[i] = dist[curr]+1;
				}
			}
		}
		for(int i=1;i<=N;i++) {
			sum+=dist[i];
		}
	}
}