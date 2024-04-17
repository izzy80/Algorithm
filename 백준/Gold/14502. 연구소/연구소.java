import java.util.*;
import java.io.*;

/**
 * 0 : 빈칸
 * 1 : 벽
 * 2 : 바이러스 위치
 * 벽은 3개를 추가로 세울 수 있음. 벽은 3개를 무조건 세워야함. -> dfs돌리기
 * 2인 위치 다 bfs stack에 미리 넣고 돌려버리기
 */

public class Main {
    static int N, M;
    static int[][] map;
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};
    static Queue<int[]> q;
    static boolean[][] visited;
    static int ans;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];


        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //solve
        ans = 0;
        DFS(0);
        System.out.println(ans);



    }
    static public void DFS(int depth){
        if(depth== 3){
            //BFS 실행
            q = new LinkedList<>();
            visited = new boolean[N][M];
            for(int i=0; i < N; i++){
                for(int j=0; j < M; j++){
                    if(map[i][j]==2){
                        q.add(new int[]{i,j});
                        visited[i][j] = true;
                    }
                }
            }

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

        for(int i=0; i < N; i++){
            for(int j=0; j < M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1; //벽 처리
                    DFS(depth+1);
                    map[i][j] = 0; //초기화
                }
            }
        }
    }

    static public void BFS(){
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int r = tmp[0];
            int c = tmp[1];

            for(int m=0; m < 4; m++){
                int nr = r + mover[m];
                int nc = c + movec[m];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 0){
                    q.add(new int[]{nr,nc});
                    visited[nr][nc] = true;
                }


            }


        }
    }

}