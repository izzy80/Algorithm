import java.util.*;
import java.io.*;

/**
 * 케빈 베이컨의 수가 가장 작은 사람
 * 여러명이라면 번호가 가장 작은 사람
 */
public class Main {
    static ArrayList<Integer>[] graph;
    static int N,M;
    static boolean[] visited;
    static int answer = -1;
    static int min = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //유저의 수
        M = Integer.parseInt(st.nextToken()); //친구 관계의 수

        graph = new ArrayList[N+1];
        for(int i=1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        arr = new int[N+1];
        for(int i=1; i <= N; i++){
            bfs(i);
        }

        for(int i=1; i <= N; i++){
            if(min == arr[i]) {
                System.out.println(i);
                break;
            }
        }


    }

    public static void bfs(int idx){
        visited = new boolean[N+1];

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{idx, 0});
        visited[idx] = true;

        int cnt = 0;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int now = tmp[0];
            int dist = tmp[1];

            for(int i : graph[now]){
                if(visited[i]) continue;
                cnt += dist+1;
                q.add(new int[]{i, dist+1});
                visited[i] = true;
            }
        }

        arr[idx] = cnt;
//        System.out.println("idx = "+idx+"cnt = "+cnt);
        if(min > cnt) {
            min = cnt;
        }
    }

}