import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 0 : 빈칸
 * 1 : 벽
 * 2 : 바이러스
 */
public class Main {
    static int N, M;
    static int[][] map;
    static int max;
    static boolean[][] visited;

    static Queue<int[]> q;

    static int[] mover = {-1, 1, 0, 0};
    static int[] movec = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j< M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //
        max = Integer.MIN_VALUE;
        DFS(0);

        System.out.println(max);
    }

    private static void DFS(int depth) {
        if(depth == 3){
            BFS(); //BFS 돌고
            //여기서 max 측정
            int size = 0;
            for(int i=0; i< N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j] == 0 && !visited[i][j]) {
                        //0인데 방문하지 않았다는 것은 바이러스에 감염되지 않았다는 것
                        size++;
                    }
                }
            }
            if(max < size) max = size;
            return;
        }

        for(int i=0; i< N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j]== 0){
                    map[i][j] = 1;
                    DFS(depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void BFS() {
        //depth가 3개라는 것은 벽을 3개를 다 세웠다는 것
        //이때 BFS를 돌면서
        //depth가 3일때마다 q를 다시 생성
        q = new LinkedList<>();
        visited = new boolean[N][M]; //방문배열도 depth=3일때마다 새로 생성
        for(int i=0; i < N; i++){
            for(int j=0; j< M; j++){
                if(map[i][j] == 2){ //바이러스가 있다면 2
                    q.add(new int[]{i, j});
                    visited[i][j] = true; //방문처리
                    //바이러스는 동시에 확산되니까 미리 데이터를 큐에 넣어준다.
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int m = 0; m < 4; m++){
                int nr = cur[0] + mover[m];
                int nc = cur[1] + movec[m];

                if(nr <0 || nr >= N || nc < 0|| nc >= M) continue;
                if(visited[nr][nc]) continue; //이미 방문했다면 지나가
                if(map[nr][nc] == 1) continue;
                if(map[nr][nc] == 0){//바이러스가 0일때만 길을 지나가는 것이 가능하다.
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}