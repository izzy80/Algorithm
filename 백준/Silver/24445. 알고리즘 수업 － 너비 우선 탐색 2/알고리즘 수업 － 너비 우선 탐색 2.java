import java.io.*;
import java.util.*;

public class Main {
    static int N,M,R;
    static ArrayList<Integer>[] graph;
    static int[] orders;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //정점의 수
        M = Integer.parseInt(st.nextToken()); //간선의 수
        R = Integer.parseInt(st.nextToken()); //시작정점

        graph = new ArrayList[N+1];
        for(int i=1; i<= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i < M; i++){
            st  = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        //내림차순으로 정렬

        //bfs
        BFS(R);

        //출력
        StringBuilder sb = new StringBuilder();
        for(int i=1; i <=N; i++){
            sb.append(orders[i]).append("\n");
        }


        System.out.println(sb.toString());
    }

    public static void BFS(int idx){
        orders = new int[N+1];
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        visited[idx] = true;
        int orderCnt = 1;

        while(!q.isEmpty()){
            int cur = q.poll();
            orders[cur] = orderCnt++;
            ArrayList<Integer> list = graph[cur];
            Collections.sort(list, Collections.reverseOrder());
            for(int next : list){
                if(visited[next]) continue;
                q.add(next);
                visited[next] = true;
            }
        }
    }
}