import java.util.*;
import java.io.*;

public class Main {
    static int M,N,K;
    static int[][] map;
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};
    static boolean[][] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int tc = 0; tc < T; tc++){
            ans = 0;
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            //map에 배추 심기
            for(int i=0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int c =  Integer.parseInt(st.nextToken());
                int r =  Integer.parseInt(st.nextToken());
                map[r][c] = 1;
            }

            // bfs 돌리기
            for(int i=0; i < N; i++){
                for(int j=0; j < M; j++){
                    if(map[i][j] == 1 && !visited[i][j]){
                        BFS(i,j);
                        ans++;
                    }
                }
            }

            sb.append(ans).append("\n");

        }



        System.out.println(sb.toString());



    }

    public static void BFS(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int cr = tmp[0];
            int cc = tmp[1];

            for(int m=0; m < 4; m++){
                int nr = cr+mover[m];
                int nc = cc+movec[m];

                if(nr < 0 || nr >= N || nc < 0 ||nc >= M) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 1){
                    q.add(new int[]{nr,nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }
}