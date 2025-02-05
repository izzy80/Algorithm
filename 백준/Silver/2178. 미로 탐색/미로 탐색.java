import java.util.*;
import java.io.*;

/**
 * 1 : 이동할 수 있는 칸
 * 0 : 이동할 수 없는 칸
 *
 * (1,1) -> (N,M)
 * 이동할 때 지나야 하는 최소의 칸
 */

public class Main {
    static int N, M;
    static int[][] miro;
    static int[][] dist;
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new int[N][M];

        for(int i = 0;  i < N ; i++){
            String str = br.readLine();
            for(int j=0; j < M; j++){
                miro[i][j] = str.charAt(j)-'0';
            }
        }

        //solve
        BFS();

        //print
        System.out.println(dist[N-1][M-1]);
    }

    public static void BFS(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        dist = new int[N][M];
        dist[0][0] = 1;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int cr = now[0];
            int cc = now[1];

            if(cr == N-1 && cc == M-1){
                return;
            }

            for(int m =0; m < 4; m++){
                int nr = cr + mover[m];
                int nc = cc + movec[m];

                if(nr <0 || nr >= N || nc <0 || nc >= M) continue;
                if(miro[nr][nc] != 1) continue;
                if(dist[nr][nc] != 0) continue;
                q.add(new int[]{nr,nc});
                dist[nr][nc] = dist[cr][cc]+1;
            }
        }
    }
}