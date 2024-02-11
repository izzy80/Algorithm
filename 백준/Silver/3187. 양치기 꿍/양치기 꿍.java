import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R,C;
    static char[][] map;
    static boolean[][] visited;
    static int[] mover = {-1,0,1,0};
    static int[] movec = {0,1,0,-1};
    static int wolfCnt, sheepCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0; i< R; i++){
            String str = br.readLine();
            for(int j=0; j< C; j++){
                map[i][j] =str.charAt(j);
            }
        }

        //dfs
        int totalWolf = 0;
        int totalSheep = 0;
        for(int i=0; i<R; i++){
            for(int j=0; j< C; j++){
                if(!visited[i][j] && (map[i][j] == 'v' || map[i][j] == 'k')){
                    wolfCnt = 0;
                    sheepCnt = 0;
                    dfs(i, j);

                    if(wolfCnt >= sheepCnt){
                        sheepCnt = 0;
                    }
                    else{
                        wolfCnt = 0;
                    }
                    totalWolf += wolfCnt;
                    totalSheep += sheepCnt;
                }
            }
        }
        System.out.println(totalSheep + " "+ totalWolf);

    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;
        if(map[r][c] == 'v') wolfCnt++;
        if(map[r][c] == 'k') sheepCnt++;


        for(int i=0; i< 4; i++){
            int nr = r + mover[i];
            int nc = c + movec[i];

            if(nr <0 || nr >= R || nc < 0|| nc >= C) continue;
            if(visited[nr][nc] || map[nr][nc] == '#') continue;
            dfs(nr,nc);
        }


    }
}