import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int W, H;
    static int[][] map;

    static int[] mover = {-1, 1, 0, 0,-1,-1,1,1};
    static int[] movec = {0, 0, -1, 1,-1,1,-1,1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if(W ==0 && H == 0) break;

            map = new int[H][W];
            visited = new boolean[H][W];

            for(int i=0; i< H; i++){
                st  = new StringTokenizer(br.readLine());
                for(int j=0; j < W; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt =0;
            for(int i=0; i< H; i++){
                for(int j=0; j < W; j++){
                    if(map[i][j] == 1 && !visited[i][j]){ //땅
                        dfs(i,j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }

    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;

        for(int m=0; m< 8; m++){
            int nr = r + mover[m];
            int nc = c + movec[m];

            if(nr < 0 || nr >= H || nc <0 || nc >= W) continue;
            if(visited[nr][nc] || map[nr][nc] == 0) continue;
            dfs(nr, nc);
        }

    }
}