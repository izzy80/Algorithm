import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int pair_cnt;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //컴퓨터의 수
        pair_cnt = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        visited = new boolean[N+1];
        for(int i=0; i < N+1; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i < pair_cnt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        DFS(1);

        //solve
        int ans = 0;
        for(int i=1; i <= N; i++){
            if(visited[i]) ans++;
        }
        System.out.println(ans-1); //1번 컴퓨터 제외 
    }

    static public void DFS(int idx){

        visited[idx] = true;

        for(int value : graph.get(idx)){//현재 idx와 연결된 다른 값
            if(visited[value]) continue;
            DFS(value);
        }
    }
}