import java.util.*;
import java.io.*;

/**
 * 섬의 개수를 세라
 * 가로, 세로, 대각선 => 걷기 가능
 * 1 : 땅
 * 0 : 바다
 */

public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static final int GROUND = 1;
    static final int SEA = 0;
    static int[] mover = {0,0,-1,1, -1,-1,1,1};
    static int[] movec = {-1,1,0,0, -1,1,1,-1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            String str = br.readLine();
            st = new StringTokenizer(str);
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0) break;

            map = new int[N][M];
            for(int i=0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j < M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

//            System.out.println(Arrays.deepToString(map));

            //solve
            visited = new boolean[N][M];
            int cnt = 0;
            for(int i=0; i < N; i++){
                for(int j=0; j < M; j++){
                    if(map[i][j] == GROUND && !visited[i][j]){
                        bfs(i,j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        } //tc
        System.out.println(sb.toString());

    }

    public static void bfs(int r, int c){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r,c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int cr = now[0];
            int cc = now[1];

            for(int m=0; m < 8; m++){
                int nr = cr + mover[m];
                int nc = cc + movec[m];

                if(nr < 0 || nr >= N || nc <0 || nc>=M) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == SEA) continue;
                q.add(new int[]{nr,nc});
                visited[nr][nc] = true;
            }
        }
    }
}