import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;

    //dfs
    static boolean[] dfsVisited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        for(int i=0; i< N+1; i++){
            graph[i] = new ArrayList<>();
        }
        //값 집어넣기
        for(int i=0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        //정렬하기
        for(int i=1; i<= N; i++){
            Collections.sort(graph[i]);
        }


        //dfs
        dfsVisited = new boolean[N+1];
        sb = new StringBuilder();
        DFS(V);
        System.out.println(sb.toString());

        //bfs
        sb = new StringBuilder();
        BFS(V);
        System.out.println(sb.toString());
    }

    private static void BFS(int idx) {
        boolean[] bfsVisited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        bfsVisited[idx] = true;
        sb.append(idx+" ");


        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i=0; i<graph[cur].size(); i++){
                int now = graph[cur].get(i);
                if(bfsVisited[now]) continue;
                q.add(now);
                bfsVisited[now] = true;
                sb.append(now).append(" ");
            }
        }
    }

    private static void DFS(int idx) {
       sb.append(idx).append(" ");
       dfsVisited[idx] = true;

       for(int i=0; i<graph[idx].size(); i++){
           int cur = graph[idx].get(i);

           if(!dfsVisited[cur]){
               DFS(cur);
           }
       }


    }
}