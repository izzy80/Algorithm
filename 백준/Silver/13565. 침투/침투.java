import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static String answer;

    static int[] mover = {-1,0,1,0};
    static int[] movec = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        //0 : 전류가 통함. 흰색
        //1 : 전류가 통하지 않음. 검은색
        for(int i=0; i< M; i++){
            String str = br.readLine();
            for(int j=0; j< N; j++){
                map[i][j] = (str.charAt(j) == '0')?0:1; //0이면 0, 아니면 1
            }
        }

        answer = "NO";
        for(int i=0; i< M; i++){
            for(int j=0;j < N; j++){
                if(!visited[i][j] && map[i][j] == 0 && i == 0){
                    dfs(i, j);
                }
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;
        if(r == M-1){
            answer = "YES";
            return;
        }


        for(int m =0; m < 4; m++){
            int nr = r + mover[m];
            int nc = c + movec[m];

            if(nr <0 || nr >= M || nc <0 || nc >= N) continue;
            if(visited[nr][nc] || map[nr][nc] == 1) continue;
            dfs(nr, nc);
        }

    }
}