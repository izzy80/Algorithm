import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for(int i=0; i < N+1; i++){
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0; i< N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        parent = new int[N + 1];
        visited = new boolean[N + 1];
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=N; i++){
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void dfs(int cur) {
        visited[cur] = true;

        for (int i = 0; i < graph[cur].size(); i++) {
            int next = graph[cur].get(i);

            if(!visited[next]){
                dfs(next);
                parent[next] = cur;
            }

        }
    }
}