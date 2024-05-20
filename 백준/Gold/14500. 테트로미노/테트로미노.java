import java.util.*;
import java.io.*;


public class Main {
    static int max = Integer.MIN_VALUE;
    static int N,M;
    static int[][] map;
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 전체 탐색 (dfs)
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visited[i][j] = true;
                DFS(i,j,map[i][j],1);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    static public void DFS(int r, int c, int sum, int cnt){
        if(cnt == 4){
            max = Math.max(max,sum);
            return;
        }

        //상하좌우
        for(int m=0; m < 4; m++){
            int nr = r + mover[m];
            int nc = c + movec[m];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if(visited[nr][nc]) continue;

            if(cnt == 2){
                visited[nr][nc] = true;
                DFS(r,c,sum+map[nr][nc],cnt+1);
                visited[nr][nc] = false;
            }
            visited[nr][nc] = true;
            DFS(nr,nc,sum+map[nr][nc],cnt+1);
            visited[nr][nc] = false;

        }
    }
}