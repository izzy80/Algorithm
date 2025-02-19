import java.util.*;
import java.io.*;

/**
 * 원숭이는 K번만 말과 같이 움직이고 그 외는 원숭이처럼 인접한 곳만 이동 가능
 * (0,0) -> (H-1, W-1) 최소 거리는? 도착 못 하면 -1
 * 0: 이동 가능 , 1 : 이동 불가능
 */
public class Main {
    static int answer = -1;
    static int W,H;
    static int[][] map;
    static boolean[][][] visited;

    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};

    static int[] mover_h = {-1,-2,-2,-1,1,2,2,1};
    static int[] movec_h = {-2,-1,1,2,-2,-1,1,2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for(int i=0; i < H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //sovle
        bfs(0,0,K);

        //print
        System.out.println(answer);
    }

    public static void bfs(int r, int c, int k){
        Queue<int[]> q = new ArrayDeque<>();
        visited = new boolean[H][W][k+1];
        q.add(new int[]{r,c,0,0}); //r,c,현재 말 이용 횟수, 거리
        visited[r][c][0] = true;


        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int cr = tmp[0];
            int cc = tmp[1];
            int chorse = tmp[2];
            int cdist = tmp[3];

            if(cr == H-1 && cc == W-1){
                answer = cdist;
                return;
            }

            //말 이동
            if(chorse < k) {
                for(int m=0; m < 8; m++){
                    int nr = cr + mover_h[m];
                    int nc = cc + movec_h[m];
                    if(nr <0 || nr >= H || nc < 0  || nc>= W) continue;
                    if(map[nr][nc] == 1) continue;
                    if(visited[nr][nc][chorse+1]) continue;
                    q.add(new int[]{nr,nc, chorse+1, cdist+1});
                    visited[nr][nc][chorse+1] = true;
                }
            }
            // 인접 이동
            for(int m=0; m < 4; m++){
                int nr = cr + mover[m];
                int nc = cc + movec[m];
                if(nr <0 || nr >= H || nc < 0  || nc>= W) continue;
                if(visited[nr][nc][chorse]) continue; //방문했다면
                if(map[nr][nc] == 1) continue; //지나갈 수 없다면
                q.add(new int[]{nr,nc, chorse, cdist+1});
                visited[nr][nc][chorse] = true;
            }
        }
    }
}