import java.util.*;
import java.io.*;

/**
 * 현재위치에서 나이트가 다음위치로 이동할 때 최소 몇 번 만에 이동?
 *
 */
public class Main {
    static int N;
    static int[][] dist;
    static boolean[][] visited;
    static int endr, endc;
    static int[] mover = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] movec = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int tc = 0; tc < T; tc++){
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int startr = Integer.parseInt(st.nextToken());
            int startc = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endr = Integer.parseInt(st.nextToken());
            endc = Integer.parseInt(st.nextToken());

            int cnt = bfs(startr,startc);
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int bfs(int r, int c){
        dist = new int[N][N];
        Queue<int[]> q = new ArrayDeque<>();
        visited = new boolean[N][N];
        q.add(new int[]{r,c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int cr = now[0];
            int cc = now[1];
            if(cr == endr && cc == endc) return dist[endr][endc];

            for(int m=0; m < 8; m++){
                int nr = cr + mover[m];
                int nc = cc + movec[m];

                if(nr < 0 || nr >= N || nc <0 || nc >= N) continue;
                if(visited[nr][nc]) continue;
                q.add(new int[]{nr,nc});
                dist[nr][nc] = dist[cr][cc]+1;
                visited[nr][nc] = true;
            }
        }

        return 0;
    }
}