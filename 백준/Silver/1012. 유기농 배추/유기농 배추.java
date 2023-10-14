import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M,N,K;
    static int[][] map;
    static boolean[][] visited;

    static int cnt;

    static int[] mover = new int[]{-1,0,1,0};
    static int[] movec = new int[]{0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc =0; tc < T ; tc ++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for(int i=0; i< K;i++){
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r =  Integer.parseInt(st.nextToken());
                map[r][c] = 1;
            }

            cnt = 0;

            for(int i=0; i<N;i++){
                for(int j=0; j< M;j++){
                    if(map[i][j] == 1 && !visited[i][j]){
                        BFS(i,j);
                    }
                }
            }

            System.out.println(cnt);
        }//test
    }//main

    private static void BFS(int r, int c) {
        Queue<int[]> q = new LinkedList<>();

        visited[r][c] = true;
        q.add(new int[]{r,c});

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int cr = tmp[0];
            int cc = tmp[1];

            for(int m =0; m<4;m++){
                int nr = cr + mover[m];
                int nc = cc + movec[m];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(visited[nr][nc] || map[nr][nc] == 0) continue;

                visited[nr][nc] = true;
                q.add(new int[]{nr,nc});
            }

        }
        cnt++;


    }
}