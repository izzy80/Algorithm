import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] map;
    static int[][] visited;
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];
        for(int i=0; i < N; i++){
            String str = br.readLine();
            for(int j =0; j < M; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        BFS(0,0);
//        System.out.print(Arrays.deepToString(visited));
        System.out.print(visited[N-1][M-1]);
    }

    static public void BFS(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c] = 1;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int cr = tmp[0];
            int cc = tmp[1];

            for(int m = 0; m < 4; m++){
                int nr = cr + mover[m];
                int nc = cc + movec[m];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(visited[nr][nc] != 0) continue;
                if(map[nr][nc] == 0) continue;
                q.add(new int[]{nr,nc});
                visited[nr][nc] = visited[cr][cc]+1;
            }
        }
    }
}