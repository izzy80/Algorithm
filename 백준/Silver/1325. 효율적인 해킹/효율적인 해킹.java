import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static ArrayList<Integer>[] graph;
    static int cnt;
    static int max;
    static int[] answer;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=0; i< N+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }

        //dfs
        max = Integer.MIN_VALUE;
        answer = new int[N+1];


        for(int i=1; i<=N; i++){
            cnt =0;
            visited = new boolean[N + 1];
            bfs(i);
//            System.out.println("cnt = "+cnt);
            if(max < cnt) max = cnt;
            answer[i] = cnt;
        }

        //출력
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<= N; i++){
            if(answer[i] == max){
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString());


    }

    private static void bfs(int idx) {
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        visited[idx] = true;
        cnt++;

        while(!q.isEmpty()){
            int cur = q.poll();
            cnt++;

            for(int i=0; i<graph[cur].size(); i++){
                int next = graph[cur].get(i);
                if(!visited[next]){
                    q.add(next);
                    visited[next] = true; 
                }
            }
        }
    }
}