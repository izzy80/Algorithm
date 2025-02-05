import java.util.*;
import java.io.*;

/**
 * 0 : 배추 심지x
 * 1 : 배추 심음
 *
 * 최소의 배추 흰지렁이 구하기
 */
public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc = 0; tc < T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            for(int i=0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                map[r][c] = 1;
            }
            //solve
            int answer = 0;
            visited = new boolean[N][M];
            for(int i=0; i < N; i++){
                for(int j=0; j< M; j++){
                    if(map[i][j] == 1 && !visited[i][j]){
                        BFS(i,j);
                        answer++;
                    }
                }
            }

            //print
            System.out.println(answer);
        }
    }

    public static void BFS(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int cr = now[0];
            int cc = now[1];

            for(int m=0; m < 4;m++){
                int nr = cr+ mover[m];
                int nc = cc+ movec[m];

                if(nr <0 || nr >= N || nc <0 || nc>= M) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 0) continue;
                q.add(new int[]{nr,nc});
                visited[nr][nc] = true;
            }
        }
    }
}