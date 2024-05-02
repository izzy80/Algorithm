import java.util.*;
import java.io.*;


public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static StringBuilder sb;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i=1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        //정렬
        for(int i =1; i <=N; i++){
            Collections.sort(graph[i], (o1,o2) -> {
                return o1-o2;
            });
        }
        sb = new StringBuilder();

        //solve
        visited = new boolean[N+1];
        DFS(V);
        sb.append("\n");
        BFS(V);

        //출력
        System.out.println(sb.toString());
    }

    static public void DFS(int idx){
        visited[idx] = true;
        sb.append(idx).append(" ");

        for(int next : graph[idx]) {
            if (visited[next]) continue;
            DFS(next);
        }

    }

    static public void BFS(int idx){
        visited = new boolean[N+1]; //다시 갱신
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        visited[idx] = true;

        while(!q.isEmpty()){
            int tmp = q.poll();
            sb.append(tmp).append(" ");

            for(int next : graph[tmp]){
                if(visited[next]) continue;
                q.add(next);
                visited[next] = true;
            }
        }
    }
}