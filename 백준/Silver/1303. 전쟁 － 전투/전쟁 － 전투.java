import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static char[][] map;
    static boolean[][] visited;
    static int w_cnt, b_cnt;
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i=0; i <N; i++){
            String tmp = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = tmp.charAt(j);
            }
        }

        //solve
        w_cnt = 0;
        b_cnt = 0;
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j < M; j++){
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    int cnt = dfs(i,j,map[i][j]);
                    if(map[i][j] == 'W'){
                        w_cnt+=(int)Math.pow(cnt,2);
                    }
                    else{
                        b_cnt += (int)Math.pow(cnt,2);
                    }
                }
            }
        }

        System.out.println(w_cnt+" "+b_cnt);



    }

    public static int dfs(int r, int c, char type){
        int cnt = 1;

        for(int m=0;m<4; m++){
            int nr = r + mover[m];
            int nc = c + movec[m];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if(visited[nr][nc]) continue;
            if(type != map[nr][nc]) continue;

            visited[nr][nc] = true;
            cnt += dfs(nr,nc,type);
        }

        return cnt;

    }
}