import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] map;
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};
    static Queue<int[]> q;
    static boolean[][] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j< M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;
        DFS(0);
        System.out.println(ans);

    }

    static public void DFS(int depth){
        if(depth == 3){
            //바이러스가 퍼질 수 있는 칸 다 q에 미리 집어넣음
            q = new LinkedList<>();
            visited = new boolean[N][M];
            for(int i=0; i < N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j] == 2){
                        q.add(new int[]{i,j});
                        visited[i][j] = true;
                    }
                }
            }
            // 바이러스 퍼트리기
            BFS();
            //안전 영역
            int cnt = 0;
            for(int i=0; i < N; i++){
                for(int j=0; j < M; j++){
                    if(map[i][j] == 0 && !visited[i][j]){
                        cnt++;
                    }
                }
            }
            ans = Math.max(ans, cnt);
            return;
        }
        //벽 세우기
        for(int i=0; i <N; i++){
            for(int j=0; j < M;j++){
                if(map[i][j] == 0){
                    map[i][j] = 1; //벽세우기
                    DFS(depth+1);
                    map[i][j] = 0; //다시 취소
                }
            }
        }
    }

    static public void BFS(){
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            for(int m=0; m <4; m++){
                int nr = tmp[0]+ mover[m];
                int nc = tmp[1]+ movec[m];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(map[nr][nc] == 0 && !visited[nr][nc]) {
                    q.add(new int[]{nr,nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }
}