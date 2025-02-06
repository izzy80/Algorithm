import java.util.*;
import java.io.*;


public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i <= N ; i++){
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        answers = new int[N+1];
        for(int i=0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i=2; i<= N; i++){
            sb.append(answers[i]).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void dfs(int idx){
        visited[idx] = true;

        for(int i : graph[idx]){
            if(visited[i]) continue;
            visited[i] = true;
            answers[i] = idx;
            dfs(i);

        }
    }
}