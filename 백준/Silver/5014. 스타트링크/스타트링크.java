import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	/*
	 * 입력
	 * F(총 층), S(강호가 있는 층), G(스타트링크 층), U(위로 u층 올라감), D(아래로 d층 내려감)가 주어짐. 
	 * 건물을 1층부터 시작하고, 가장 높은 층은 F층 
	 * 
	 * 출력
	 * S층에서 G층으로 가기 위해 눌러야하는 버튼의 수의 최소값
	 * 엘리베이터로 이동할 수 없으면 use the stairs를 출력 
	 */
	static int F, S, G, U, D;
	static int visited[]; //버튼 몇 번 눌렀는지 계산 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		
		visited = new int[F+1];
		
		BFS(F,S,G,U,D);
	}//main

	private static void BFS(int f, int s, int g, int u, int d) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		visited[s] = 1; //시작점 방문(버튼 안 눌렀지만 눌른걸로 침)
		
		while(!q.isEmpty()) {
			int c = q.poll(); //현재 위치 
			
			if(c == g) {//현재위치 = 스타트링크 층
				System.out.println(visited[c]-1); //default로 1한 것 뺀다 
			}
			
			if(c+u <= f && visited[c+u]==0) {
				//현재위치 + 윗층 <= 최고층 && 방문 안 함
				visited[c+u] = visited[c]+1;
				q.add(c+u);
			}
			
			if(c-d >0 && visited[c-d]==0) {
				//현재위치 - 아래층 >0 && 방문 안 함
				visited[c-d] = visited[c]+1;
				q.add(c-d);
			}
		}
		
		if(visited[g] ==0) {
			System.out.println("use the stairs");
		}
		
	}

}