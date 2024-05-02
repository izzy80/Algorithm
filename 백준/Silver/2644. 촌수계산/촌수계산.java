import java.util.*;
import java.io.*;


public class Main {
    static int N;
    static int end;
    static ArrayList<Integer>[] graph;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for(int i=1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[N+1];
        for(int i=0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        ans = 0;
        DFS(start, visited, 0);
        System.out.println(ans == 0 ? -1 : ans);
    }
    static public void DFS(int idx, boolean[] visited, int depth){
        if(idx == end){
            ans = depth;
            return;
        }
        visited[idx] = true;
        for(int next : graph[idx]){
            if(visited[next]) continue;
            DFS(next, visited, depth+1);
            visited[next] = false;
        }

    }
}