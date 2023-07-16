import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	static int N,max;
	static int[] dist;
	static class Node {
		int point;
		int dist;
		public Node(int point, int dist) {
			this.point = point;
			this.dist = dist;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //헛간의 개수 
		int M = sc.nextInt(); //헛간이 가진 M개의 양방향 길 
		
		list = new ArrayList<>();
		visited = new boolean[N+1];
		dist = new int[N+1];
		max = Integer.MIN_VALUE; 
		
		for(int i=0;i<N+1;i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt(); 
			list.get(a).add(b);
			list.get(b).add(a);
		}
		//bfs
		BFS();
		
		//
		int maxcnt = 0; 
		int maxidx = 0;
		for(int i=1; i<N+1;i++) {
			if(dist[i] == max) {
				if(maxidx==0) {
					maxidx = i;
				}
				maxcnt++;
			}
		}
		System.out.println(maxidx + " "+ max+ " "+maxcnt);
	}//main

	private static void BFS() {
		Queue<Node> q = new LinkedList<>(); 
		q.offer(new Node(1,0)); //시작점
		visited[1] = true; 
		
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			max = Math.max(max, cur.dist); 
			dist[cur.point] = cur.dist;  
			
			for(int i=0;i < list.get(cur.point).size();i++) {
				int next = list.get(cur.point).get(i); //cur의 point와 연결된 점을 next로 할당
				
				if(!visited[next]) {
					q.offer(new Node(next,cur.dist+1));
					visited[next] = true;
				}
			}
		}//while 
		
	}//BFS 
}