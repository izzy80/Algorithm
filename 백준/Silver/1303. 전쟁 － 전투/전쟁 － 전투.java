import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
W : 아군
B : 적군
 */


public class Main {
    static int N,M;
    static char[][] map;
    static boolean[][] visited;
    static int[] mover = {-1,0,1,0};
    static int[] movec = {0,1,0,-1};
    static int whiteCnt, blueCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[M][N];
        visited = new boolean[M][N];
        for(int i=0; i<M; i++){
            String tmp = br.readLine();
            for(int j=0; j< N; j++){
                map[i][j] = tmp.charAt(j);
            }
        }
        int blueScore = 0;
        int whiteScore = 0;
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                blueCnt = 0;
                whiteCnt = 0;
                if(!visited[i][j]) dfs(i,j);
                blueScore += blueCnt*blueCnt;
                whiteScore += whiteCnt*whiteCnt;
            }
        }

        System.out.println(whiteScore +" "+blueScore);


    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;
        if(map[r][c] == 'W') whiteCnt++;
        else blueCnt++;

        for(int m=0; m<4; m++){
            int nr = r + mover[m];
            int nc = c + movec[m];

            if(nr < 0 || nr >= M || nc <0 || nc >= N) continue;
            if(visited[nr][nc]) continue;
            if(map[r][c] == 'W' && map[nr][nc] == 'W') dfs(nr,nc);
            else if(map[r][c] == 'B' && map[nr][nc] == 'B') dfs(nr,nc);
        }

    }
}