import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M,K;
    static int[][] map;
    static boolean[][] visited;
    static int answer;
    static int cnt;
    static int[] mover = {-1,0,1,0};
    static int[] movec = {0,1,0,-1};



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        int r,c;
        for(int i=0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken())-1;
            c = Integer.parseInt(st.nextToken())-1;

            map[r][c] = 1;
        }

        answer = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            for(int j =0; j< M; j++){
                cnt = 0;
                if(!visited[i][j]&&map[i][j] == 1){
                    dfs(i,j);
                    answer = Math.max(answer, cnt);
                }
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;
        cnt++;

        for(int m=0; m< 4; m++){
            int nr = r + mover[m];
            int nc = c + movec[m];

            if(nr <0 || nr >= N || nc < 0 || nc >= M) continue;
            if(visited[nr][nc] || map[nr][nc] == 0) continue;
            dfs(nr,nc);
        }


    }
}