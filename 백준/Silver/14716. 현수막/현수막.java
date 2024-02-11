import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M,N;
    static int[][] map;
    static boolean[][] visited;
    static int[] mover = {-1,0,1,0,-1,-1,1,1};
    static int[] movec = {0,1,0,-1,-1,1,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];
        for(int i=0; i< M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j< N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //dfs
        int cnt =0;
        for(int i=0; i<M; i++){
            for(int j =0; j< N; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    dfs(i,j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;

        for(int m =0; m<8;m++){
            int nr = r + mover[m];
            int nc = c + movec[m];

            if(nr <0 || nr >= M || nc < 0|| nc >= N) continue;
            if(visited[nr][nc] || map[nr][nc] == 0) continue;
            dfs(nr,nc);
        }
    }
}