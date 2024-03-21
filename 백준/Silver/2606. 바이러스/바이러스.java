import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //컴퓨터의 수
        int P = Integer.parseInt(br.readLine()); //쌍의 수

        graph = new ArrayList[N+1];
        for(int i=1; i <= N ;i++){
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i=0; i < P; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i=1; i<=N; i++){
            Collections.sort(graph[i]);
        }
        
        ans = 0;
        visited = new boolean[N+1];
        DFS(1);

        for(int i=1; i <=N; i++){
            if(visited[i]) ans++;
        }

        System.out.println(ans-1); //1번 컴퓨터 제외

    }//main

    private static void DFS(int idx) {
        visited[idx] = true;

        ArrayList<Integer> tmp = graph[idx];
        for(int i= 0; i < tmp.size(); i++){
            int next = tmp.get(i);
            if(!visited[next])
                DFS(next);
        }

    }
}