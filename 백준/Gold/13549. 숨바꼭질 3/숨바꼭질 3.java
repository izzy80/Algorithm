import java.util.*;
import java.io.*;

public class Main {
    static int N,K;
    static boolean[] visited;
    static int time = 0;
    static final int MAX = 100_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N== K) {
            System.out.println(0);
            return;
        }

        bfs(N);

        System.out.println(time);
    }

    static public void bfs(int start){
        Queue<int[]> q = new ArrayDeque<>();
        visited = new boolean[MAX+1];
        q.add(new int[]{start, 0});
        visited[start]=  true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int now = tmp[0];
            int dist = tmp[1];

            if(now == K){
                time = dist;
                return;
            }

            for(int i=0; i < 3; i++){
                int next = 0;
                switch (i){
                    case 0 :
                        next = now  * 2;
                        break;
                    case 1:
                        next = now - 1;
                        break;
                    case 2:
                        next = now + 1;
                        break;
                }

                if(next < 0 || next > MAX) continue;
                if(visited[next]) continue;
                q.add(new int[]{next, i == 0? dist:dist+1});
                visited[next] = true;
            }
        }
    }
}