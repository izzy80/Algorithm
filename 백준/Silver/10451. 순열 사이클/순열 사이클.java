import java.util.*;
import java.io.*;


public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            N = Integer.parseInt(br.readLine());
            graph= new ArrayList[N+1];
            visited = new boolean[N+1];

            for(int i=1; i <= N; i++){
                graph[i] = new ArrayList<>();
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i < N; i++){
                int number = Integer.parseInt(st.nextToken());
                graph[i+1].add(number);
                graph[number].add(i+1);
            }

            int cnt = 0;
            for(int i=1; i <= N; i++){
                if(visited[i]) continue;
                dfs(i);
                cnt++;
            }

            System.out.println(cnt);
        }
    }

    public static void dfs(int idx){
        visited[idx] = true;

        for(int i : graph[idx]){
            if(visited[i]) continue;
            visited[i] = true; 
            dfs(i);
        }
    }
}