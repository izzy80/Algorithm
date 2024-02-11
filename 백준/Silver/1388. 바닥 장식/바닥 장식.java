import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N,M;
    static char[][] map;
    static int answer;
    static boolean[][] visited;
    static int[] mover = {0,1};
    static int[] movec = {1,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로
        map = new char[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            for(int j =0; j< M; j++){
                map[i][j] = tmp.charAt(j);
            }
        }

        //dfs
        answer = 0;
        for(int i=0; i< N; i++){
            for(int j =0; j<M;j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    answer++;
                }
            }
        }

        for(int i=0; i< N; i++){
            for(int j=0; j < M; j++){
                if(!visited[i][j])
                    answer++;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;

        if(map[r][c] == '-'){
            int nc = c+1;
            if(nc < M && !visited[r][nc] && map[r][nc] == '-') dfs(r,nc);
        }
        else{
            int nr = r+1;
            if(nr < N&& !visited[nr][c] && map[nr][c] == '|') dfs(nr, c);
        }
    }
}