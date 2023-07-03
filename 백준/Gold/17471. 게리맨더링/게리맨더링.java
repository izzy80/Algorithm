import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] population, area;
	static ArrayList<Integer>[] list;
	static int min = Integer.MAX_VALUE;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		population = new int[N+1];
		list = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();
			population[i] = sc.nextInt();
		}
		
		for(int i=1;i<=N;i++) {
			int num = sc.nextInt();
			for(int j=0;j<num;j++) {
				list[i].add(sc.nextInt());
			}
		}
		
		area = new int[N+1];
		DFS(1);
		
		if(min == Integer.MAX_VALUE) {
			System.out.println("-1");
		}
		else {
			System.out.println(min);
		}
	}//main

	private static void DFS(int k) {
		if(k == N+1) {
			int area1 = 0;
			int area2 = 0; 
			
			for(int i=1;i<=N;i++) {
				if(area[i] == 1) {
					area1 += population[i];
				}
				else {
					area2 += population[i];
				}
			}
			
			visited = new boolean[N+1];
			int link = 0; //연결된 지역들의 개수를 센다. 
			
			for(int i=1;i<=N;i++) {
				if(!visited[i]) {
					BFS(i, area[i]);
					link++;
				}
			}
			if(link ==2) {
				min = Math.min(min, Math.abs(area1 - area2));
			}
			return;
		}
		area[k] = 1;
		DFS(k+1);
		
		area[k] = 2;
		DFS(k+1);
		
	}

	private static void BFS(int idx, int areaNum) {
		Queue<Integer> q = new LinkedList<>();
		visited[idx] = true;
		q.offer(idx);
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			for(int i=0;i<list[current].size();i++) {
				int next = list[current].get(i);
				if(area[next] == areaNum && !visited[next]) {
					q.offer(next);
					visited[next] = true;
				}
			}
			
		}
	}
}