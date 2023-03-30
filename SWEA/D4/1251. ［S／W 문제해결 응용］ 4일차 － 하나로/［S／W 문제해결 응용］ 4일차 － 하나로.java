import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static int N; // 섬의 갯수  = 정점의 갯수 
	static int[][] island;//섬의 좌표 위치
	
	// 거리 구하기 위해서 
	static int[] sel; //combi 선택된 셀 
	static class Node implements Comparable<Node>{
		int st;
		int ed;
		long w;

		public Node(int st,int ed, long w) {
			super();
			this.st = st;
			this.ed = ed;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Long.compare(this.w, o.w);
		}
	}
	static double E;
	static final int INF = Integer.MAX_VALUE;
	static List<Node>[] adjList;// 인접리스트 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			N = sc.nextInt();
			// 1. 섬 좌표 받기 
			island = new int[2][N];
			for(int i=0;i<2;i++) {
				for(int j=0;j<N;j++) {
					island[i][j] = sc.nextInt(); 
				}
			}
			//System.out.println(Arrays.deepToString(island)); // 배열 확인 
			
			// 2. 거리 구하기 
			// 2-1. 시작값, 끝값, 거리 저장한 리스트
			sel = new int[2]; 
			adjList = new ArrayList[N];
			E = sc.nextDouble(); // 환경부담 세율 실수 
			for(int i=0; i<N; i++) {
				adjList[i] = new ArrayList<>();	
			}
			combination(0,0);
//			for(int i=0;i<adjList.length;i++) {
//				for(int j=0;j<adjList[i].size();j++) {
//					System.out.println("st = "+adjList[i].get(j).st+",ed = "+adjList[i].get(j).ed+",w = "+adjList[i].get(j).w);
//				}
//			}
//			
		
			// 방문처리를 하기 위해서 
			boolean[] visited = new boolean[N];
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			
			visited[0] = true;
			
			pq.addAll(adjList[0]);
			
			int pick = 1; 
			long ans = 0;
			
			while(pick!=N) {
				Node n = pq.poll();
				if(visited[n.ed]) continue;
				
				ans+=n.w;
				pq.addAll(adjList[n.ed]); 
				visited[n.ed] =true;
				//System.out.println(Arrays.toString(visited));
				pick++;
			}
			System.out.println("#"+test_case+" "+Math.round(ans*E));
		}
	}

	// 거리 알기 위해서 조합 돌리기 
	private static void combination(int idx, int sidx) {
		if(sidx == 2) {
			int fir_x = island[0][sel[0]]; 
			int fir_y = island[1][sel[0]];
			int sec_x = island[0][sel[1]];
			int sec_y = island[1][sel[1]];
			long l = (long)(Math.pow((fir_x- sec_x),2)+Math.pow((fir_y- sec_y),2));
			adjList[sel[0]].add(new Node(sel[0],sel[1],l));
			adjList[sel[1]].add(new Node(sel[1],sel[0],l));
			//System.out.println(Arrays.toString(sel));
			return; 
		}
		for(int i=idx; i<=N-2+sidx;i++) {
			sel[sidx] = i; 
			combination(i+1, sidx+1);
		}
	}
}