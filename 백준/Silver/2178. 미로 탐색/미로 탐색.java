import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] map;
    static int[][] dist;
    static int[] mover = new int[]{-1,0,1,0};
    static int[] movec = new int[]{0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];
        for(int i=0;i<N;i++){
            Arrays.fill(dist[i], -1);;
        }


        for(int i=0; i<N;i++){
            String str = br.readLine();
            for(int j=0; j< M;j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

//        System.out.println(Arrays.deepToString(map));
        BFS(0,0);


        System.out.println(dist[N-1][M-1]);
    }

    private static void BFS(int r, int c) {
        Queue<int[]> q = new LinkedList<>();

        dist[r][c] = 1;
        q.add(new int[]{r,c});

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int cr = tmp[0];
            int cc = tmp[1];


            for(int i=0;i<4;i++){
                int nr = cr + mover[i];
                int nc = cc + movec[i];

                if(nr < 0 || nr >= N || nc <0 || nc >=M) continue;

                if(map[nr][nc] == 0) continue;
                if(dist[nr][nc] == -1){
                    q.add(new int[]{nr,nc});
                    dist[nr][nc] = dist[cr][cc]+1;
                }
            }
        }


    }
}