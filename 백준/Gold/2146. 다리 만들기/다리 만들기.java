import java.util.*;
import java.io.*;

/**
 * 한 섬과 다른 섬을 잇는 다리 하나만을 만들기로 함.
 * 다리를 가장 짧게 해서 돈을 아끼려고 함.
 *
 */
public class Main {
    static int N;
    static int[][] map;
    static int[][] isLand;
    static boolean[][] visited;
    static boolean[][] v;
    static int[] mover = {0,0,1,-1};
    static int[] movec = {-1,1,0,0};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        map = new int[N][N];
        isLand = new int[N][N];
        visited = new boolean[N][N];


        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //solve
        int isLandIdx = 1;
        for(int i=0; i < N; i++){
            for(int j=0; j < N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    bfs(i,j, isLandIdx);
                    isLandIdx++;
                }
            }
        }
//        System.out.println(Arrays.deepToString(isLand));
        //가장 짧은 거리 구하기
        for(int i=0; i < N; i++){
            for(int j=0; j < N; j++){
                if(isLand[i][j] != 0){
                    v = new boolean[N][N];
                    solveShort(i,j,isLand[i][j] );
                }
            }
        }


        //print
        System.out.println(answer==Integer.MAX_VALUE? 0 : answer);

    }
    public static void solveShort(int r, int c, int idx){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r,c,0});
        v[r][c] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            int cr = tmp[0];
            int cc = tmp[1];
            int cdist = tmp[2];

            for(int m =0; m < 4; m++){
                int nr = cr + mover[m];
                int nc = cc + movec[m];

                if(nr < 0 || nr >= N || nc <0 || nc >= N) continue;
                if(v[nr][nc]) continue;
                if(isLand[nr][nc] == idx){
                    //같은 지역
                    q.add(new int[]{nr,nc,cdist});
                    v[nr][nc] = true;
                }
                else if(isLand[nr][nc] == 0){
                    //다리를 놓을 수 있는 곳
                    q.add(new int[]{nr,nc,cdist+1});
                    v[nr][nc] = true;
                }
                else{
                    //다른 지역
                    answer = Math.min(answer, cdist);
                }
            }
        }
    }

    public static void bfs(int r, int c, int idx){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r,c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            int cr = tmp[0];
            int cc = tmp[1];
            isLand[cr][cc] = idx;

            for(int m =0; m < 4; m++){
                int nr = cr + mover[m];
                int nc = cc + movec[m];

                if(nr < 0 || nr >= N || nc <0 || nc >= N) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] != 1)continue;
                q.add(new int[]{nr,nc});
                visited[nr][nc] = true;
            }
        }

    }
}