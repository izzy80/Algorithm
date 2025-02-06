import java.util.*;
import java.io.*;

/**
 * 벽 3개 무조건 세움
 * 안전 영역의 최대값이 될 때의 크기는?
 *
 * 0 : 빈칸
 * 1 : 벽
 * 2 : 바이러스
 */
public class Main {
    static int N,M;
    static int[][] map;
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};
    static int answer;
    static Queue<int[]> q;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];


        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < M; j++){
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;

            }
        }
        answer = 0;
        dfs(0);

        System.out.println(answer);

    }

    public static void dfs(int depth){
        if(depth == 3){
            //BFS돌려서 바이러스 퍼트리기
            q = new LinkedList<>();
            visited = new boolean[N][M];
            for(int i=0; i < N; i++){
                for(int j=0; j < M; j++){
                    if(map[i][j] == 2 && !visited[i][j]){
                        q.add(new int[]{i,j});
                        visited[i][j] = true;
                    }
                }
            }

            bfs();

            //안전 구역 세기
            int cnt = 0;
            for(int i=0; i < N; i++){
                for(int j=0; j < M; j++){
                    if(map[i][j] == 0 && !visited[i][j]){
                        cnt++;
                    }
                }
            }
            answer = Math.max(cnt, answer);
            return;
        }

        for(int i=0; i < N; i++){
            for(int j=0; j < M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs(){
        while(!q.isEmpty()){
            int[] now = q.poll();
            int cr = now[0];
            int cc = now[1];

            for(int m=0; m < 4; m++){
                int nr = cr + mover[m];
                int nc = cc + movec[m];

                if(nr < 0 || nr >= N || nc <0 || nc >= M) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 0){
                    q.add(new int[]{nr,nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }
}