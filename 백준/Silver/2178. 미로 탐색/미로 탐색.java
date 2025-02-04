import java.util.*;
import java.io.*;

/**
 * 1 : 이동 가능
 * 0 : 이동 불가능
 * (1,1) -> (N,M)
 * 최소의 칸 수
 * 인접한 칸만 이동 가능
 */
public class Main {
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};
    static int[][] miro;
    static int[][] dist;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        miro = new int[N][M];
        dist = new int[N][M];
        for(int i=0; i < N; i++){
            String str = br.readLine();
            for(int j=0; j < M; j++){
                miro[i][j] = str.charAt(j) - '0';
            }
        }

        //solve
        bfs(0,0);

        //print
        System.out.println(dist[N-1][M-1]);
    }

    public static void bfs(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        dist[r][c] = 1;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int cr = now[0];
            int cc = now[1];

            for(int m=0; m < 4; m++){
                int nr = cr+mover[m];
                int nc = cc+movec[m];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(dist[nr][nc] != 0) continue;
                if(miro[nr][nc] !=1) continue;

                dist[nr][nc] = dist[cr][cc]+1;
                q.add(new int[]{nr,nc});
            }
        }
    }



}