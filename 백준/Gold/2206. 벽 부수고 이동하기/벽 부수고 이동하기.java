import java.util.*;
import java.io.*;

/**
 * 0 : 이동 가능
 * 1 : 이동 불가능
 *
 * (1,1) -> (N,M)
 * 벽은 한 개까지 부셔도 괜찮음
 * 안 부셔도 상관없고
 * 상하좌우 이동 가능
 * 최단 경로는?
 *
 * 불가능하면 -1
 */

public class Main {
    static int N,M;
    static int answer = -1;
    static int[][] map;
    static boolean[][][] visited;
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};

    static int NO = 1;
    static int YES = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (N - 1 == 0 && M - 1 == 0) {
            System.out.print(1);
            return;
        }

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j=0; j < M; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        //solve

        bfs();

        //print
        System.out.println(answer);
    }

    public static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        visited = new boolean[N][M][2];

        q.add(new int[]{0,0,1,1}); //r,c,거리, 벽여부 (1 : 안 부숨, 0 : 부숨)
        visited[0][0][0] = true;


        while(!q.isEmpty()){
            int[] now = q.poll();
            int cr = now[0];
            int cc = now[1];
            int dist = now[2];
            int wall = now[3];

            if(cr == N-1 && cc == M-1){
                answer = dist;
                return;
            }

            for(int m=0; m < 4; m++){
                int nr = cr + mover[m];
                int nc = cc + movec[m];

                if(nr < 0 || nr >= N || nc <0 || nc >= M) continue;
                if(map[nr][nc] == YES){
                    //이동가능
                    if(!visited[nr][nc][wall]){//아직 안 부숨, 이동 안 함
                        q.add(new int[]{nr,nc,dist+1, wall});
                        visited[nr][nc][wall] = true;
                    }
                }
                else{
                    //벽이라서 이동 불가능
                    //wall == 0이면 부순 상태로 이동 불가능
                    //wall == 1이면 벽을 하나 부순다.
                    if(wall == 1){
                        if(visited[nr][nc][1]) continue;
                        q.add(new int[]{nr,nc, dist+1, 0});
                        visited[nr][nc][0] = true;
                    }
                }
            }
        }
    }

}