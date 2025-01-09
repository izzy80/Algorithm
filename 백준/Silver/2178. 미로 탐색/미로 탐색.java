import java.util.*;
import java.io.*;

/**
 * 1: 이동할 수 있는 칸
 * 0: 이동할 수 없는 칸
 *
 * (1,1) -> (N,M)
 * 최소 칸 수
 */
public class Main {
    static int N,M;
    static int[][] map;
    static int[][] dist;
    static int ans = 0;
    static int[] mover = {0,0,1,-1};
    static int[] movec = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];

        for(int i=0; i < N; i++){
            String str = br.readLine();
            for(int j=0; j < M; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        //solve
        BFS(0,0);


        //print
//        System.out.println(Arrays.deepToString(map));
//        System.out.println(Arrays.deepToString(dist));
        System.out.println(dist[N-1][M-1]);

    }

    public static void BFS(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        dist[r][c] = 1;

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int m=0; m < 4; m++){
                int nr = tmp[0]+mover[m];
                int nc = tmp[1]+movec[m];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue; //범위 벗어남
                if(dist[nr][nc] != 0) continue;  //이미 지나간 칸
                if(map[nr][nc] == 1) {
                    q.add(new int[]{nr,nc});
                    dist[nr][nc] = dist[tmp[0]][tmp[1]]+1;
                }
            }
        }
    }

}