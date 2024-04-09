import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static char[][] map;
    static boolean[][] visited;
    static int[] mover = {1,0,-1,0};
    static int[] movec = {0,1,0,-1};
    static int personCnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];
        int startr = 0;
        int startc = 0;
        for(int i=0; i < N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                char c  = str.charAt(j);
                map[i][j] = c;
                if(c == 'I'){//도연이 위치
                    startr = i;
                    startc = j;
                }
            }
        }

        //bfs
        personCnt = 0;
        BFS(startr, startc);

        //출력
        System.out.println(personCnt == 0? "TT" : personCnt);

    }

    private static void BFS(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int cr = tmp[0];
            int cc = tmp[1];
            if(map[cr][cc] == 'P') personCnt++;

            for(int m =0; m < 4; m++){
                int nr = cr + mover[m];
                int nc = cc + movec[m];

                if(nr <0 || nr >= N || nc < 0 ||nc >= M) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 'X') continue;
                q.add(new int[]{nr,nc});
                visited[nr][nc] = true;
            }
        }

    }
}