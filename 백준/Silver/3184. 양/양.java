import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
. : 빈필드
# : 울타리
o : 양
v : 늑대

 */
public class Main {
    static int R,C;
    static char[][] map;
    static boolean[][] visited;
    static int[] mover = {-1,0,1,0};
    static int[] movec = {0,1,0,-1};
    static int sheepCnt, wolfCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i =0; i< R; i++) {
            String str = br.readLine();
            for(int j=0; j< C; j++){
                char c = str.charAt(j);
                map[i][j] =  c;
            }
        }

        int totalWolf = 0;
        int totalSheep = 0;
        for(int i=0; i < R; i++){
            for(int j=0; j < C; j++){
                if(!visited[i][j] && (map[i][j] == 'v' || map[i][j] == 'o')){
                    wolfCnt = 0;
                    sheepCnt = 0;
                    dfs(i,j);

                    if(sheepCnt > wolfCnt){
                        wolfCnt = 0;
                    }
                    else{
                        sheepCnt = 0;
                    }
                    totalWolf += wolfCnt;
                    totalSheep += sheepCnt;
                }
            }
        }

        System.out.println(totalSheep + " "+totalWolf);
    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;
        if(map[r][c] == 'v') wolfCnt++;
        if(map[r][c] == 'o') sheepCnt++;

        for(int m =0; m< 4; m++){
            int nr = r + mover[m];
            int nc = c + movec[m];

            if(nr <0 || nr >= R || nc <0 || nc >= C) continue;
            if(visited[nr][nc] || map[nr][nc] == '#') continue;
            dfs(nr,nc);
        }
    }
}