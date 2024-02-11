import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[] mover = {-1,0,1,0};
    static int[] movec = {0,1,0,-1};
    static HashSet<String> hs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 5;

        StringTokenizer st;
        map = new int[N][N];
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j< N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        hs = new HashSet<>();
        String s = new String();
        for(int i=0; i< N; i++){
            for(int j = 0; j< N; j++){
                dfs(i,j,0,s);
            }
        }

        //출력
        System.out.println(hs.size());

    }

    private static void dfs(int r, int c,int depth, String s) {
        if(depth== 6){
            hs.add(s);
            return;
        }
        for(int m =0; m<4; m++){
            int nr = r + mover[m];
            int nc = c + movec[m];

            if(nr <0 || nr >= N || nc <0 || nc >= N) continue;
            dfs(nr, nc,depth+1,s+map[nr][nc]);
        }
    }
}