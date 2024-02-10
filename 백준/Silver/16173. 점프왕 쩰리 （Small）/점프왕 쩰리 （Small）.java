import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;

    static int[] mover = {0, 1};
    static int[] movec = {1, 0};
    static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        StringTokenizer st;
        for(int i=0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = "Hing";
        //dfs
        dfs(0,0);
        System.out.println(answer);
    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;

        if(r == N-1 && c == N-1){ //마지막에 도달했다면
            answer = "HaruHaru";
            return;
        }

        for(int m =0; m<2; m++){
            int nr = r + mover[m]*map[r][c];
            int nc = c + movec[m]*map[r][c];

            if(nr < 0 || nr >= N || nc <0 || nc >= N) continue;
            if(visited[nr][nc]) continue;
            dfs(nr,nc);
        }


    }
}