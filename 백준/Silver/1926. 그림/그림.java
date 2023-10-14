import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 그림의 개수
 * 그림 중 넓이가 가장 넓은 것의 넓이
 * 0 : 색칠 X, 1 : 색칠
 */
public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static int cnt;
    static int max = Integer.MIN_VALUE;
    static int[] mover = new int[]{-1,0,1,0};
    static int[] movec = new int[]{0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i< N;i++){
            for(int j=0; j<M;j++){
                if(!visited[i][j] & map[i][j] == 1){
                    BFS(i,j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        if(cnt ==0){
            System.out.println(0);
        }
        else{
            System.out.println(max);
        }
    }//main

    private static void BFS(int r, int c) {
        Queue<int[]> q = new LinkedList<>();

        visited[r][c] = true;
        q.add(new int[]{r,c});

        int d =0;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            d++;

            int cr = tmp[0];
            int cc = tmp[1];
//            System.out.println("["+cr+"]"+"["+cc+"]");

            for(int i=0; i<4;i++){
                int nr = cr+mover[i];
                int nc = cc+movec[i];

                if(nr < 0 || nr >= N || nc < 0 || nc >=M) continue;
                if(visited[nr][nc] || map[nr][nc] == 0) continue;

                visited[nr][nc] = true;
                q.add(new int[]{nr,nc});
            }
        }
        max = Integer.max(max,d);
    }
}