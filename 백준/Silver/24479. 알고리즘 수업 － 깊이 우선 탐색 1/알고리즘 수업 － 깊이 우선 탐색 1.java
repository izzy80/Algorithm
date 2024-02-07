import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * N개의 정점, M개의 간선, 무방향 그래프
 * 1 <= 정점의 개수 <= N
 * 모든 간선의 가중치는 1
 * 정점 R에서 시작해서 DFS를 돌 때 방문 순서 출력
 * 인접 정점은 오름차순으로 방문
 */

public class Main {
    static int N,M,R;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static StringBuilder sb;

    static int depth;

    static int[] rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //정점의 수
        M = Integer.parseInt(st.nextToken()); //간선의 수
        R = Integer.parseInt(st.nextToken()); //시작 정점

        visited = new boolean[N + 1];
        rank = new int[N + 1];
        list = new ArrayList[N+1];

        for(int i=0; i<N+1;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        // 오름차순을 위해 정렬
        for(int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }

//        for (ArrayList<Integer> integers : list) {
//            System.out.println(integers);
//        }

        sb = new StringBuilder();
        depth = 1;
        DFS(R);

        //출력
        for(int i=1; i<=N; i++){
            sb.append(rank[i]).append("\n");
        }
        System.out.println(sb.toString());
    }



    private static void DFS(int idx) {
        visited[idx] = true;
        rank[idx] = depth++;


        for (int now : list[idx]) {
            if(!visited[now]){
                visited[now] = true;
                DFS(now);
            }

        }
    }
}