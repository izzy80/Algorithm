import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int R,C,K;
    static char[][] map;
    static boolean[][] visited;

    static int[] mover = {-1,0,1,0};
    static int[] movec = {0,1,0,-1};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = str.charAt(j);
            }
        }

        //dfs
        visited[R-1][0] = true;
        dfs(R-1,0,1);

        System.out.println(answer);

    }

    private static void dfs(int r, int c, int depth) {
        if(r == 0 && c == C-1){
            if(depth == K) {
                answer++;
            }
            return;
        }

        for(int i=0; i<4;i++){
            int nr = r + mover[i];
            int nc = c + movec[i];

            if(nr <0 || nr >= R || nc <0 || nc >= C) continue;
            if(visited[nr][nc] || map[nr][nc] == 'T') continue;
            visited[nr][nc] = true;
            dfs(nr, nc,depth+1);
            visited[nr][nc] = false;
        }
    }
}