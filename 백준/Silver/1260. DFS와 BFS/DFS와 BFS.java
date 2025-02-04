import java.util.*;
import java.io.*;

/**
 * dfs, bfs 결과
 * 방문 가능한 점 여러개 -> 정점 번호가 가장 작은 것부터
 * 방문 할 수 있는 점 없음 -> 종료
 * 번호는 1번부터 N번까지
 */
public class Main {
    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //정점의 개수
        M = Integer.parseInt(st.nextToken()); //간선의 개수
        V = Integer.parseInt(st.nextToken()); //탐색을 시작할 정점의 번호

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        //한 번 정렬
        for(int i=1; i <= N; i++){
            Collections.sort(graph[i]);
        }

        //solve
        dfs(V);
        sb.append("\n");
        visited = new boolean[N+1];
        bfs(V);

        //print
        System.out.println(sb.toString());
    }

    public static void dfs(int idx){
        visited[idx] = true;
        sb.append(idx).append(" ");
        
        for(int i : graph[idx]){
            if(!visited[i]){
                visited[i] = true;
                dfs(i);
            }
        }
    }

    public static void bfs(int idx){
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        visited[idx] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now).append(" ");

            for(int i : graph[now]){
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}