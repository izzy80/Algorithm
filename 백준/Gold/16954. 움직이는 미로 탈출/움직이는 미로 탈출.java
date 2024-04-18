import java.util.*;
import java.io.*;

public class Main {
    static int N = 8;
    static char[][] map;
    static int ans;
    static boolean[][] visited;
    static int[] mover = {0,0,0,-1,1,-1,-1,1,1};
    static int[] movec = {0,-1,1,0,0,-1,1,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[N][N];

        for(int i=0; i < N; i++){
            String str = br.readLine();
            for(int j=0; j < N; j++){
                map[i][j] =  str.charAt(j);
            }
        }

        //solve
        ans = 0;
        BFS(N-1, 0);
        System.out.println(ans);
    }

    static public void BFS(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});

        while(!q.isEmpty()){
            //한 턴이 끝날 때마다 방문배열 초기화. 벽이 움직여서 새로운 경로가 생길 수 있기 때문
            visited = new boolean[8][8];

            int size = q.size();
            for(int t=0; t < size; t++){
                //현재 큐에 있는 size만큼 꺼내서 탐색(큐에 있던 경로 탐색완료하면 1초가 경과한 것)
                int[] tmp = q.poll();
                if(map[tmp[0]][tmp[1]] == '#') continue;  //벽이 내려와서 현재 위치에 벽이 있다면 이동X
                if(!foundWall()) {
                    ans=1; //처음 벽이 없으면 걍 다 통과
                    return;
                }
                if(tmp[0] == 0 && tmp[1] == N-1){ //도달하면 끝
                    ans = 1;
                    return;
                }

                for(int m = 0; m < 9; m++){
                    int nr = tmp[0]+mover[m];
                    int nc = tmp[1]+movec[m];

                    if(nr <0 || nr >= N || nc < 0 || nc >= N) continue; //범위 벗어남
                    if(map[nr][nc]=='#' || visited[nr][nc]) continue; //이미 방문했거나 다음위치가 벽임
                    q.add(new int[]{nr,nc});
                    visited[nr][nc] = true;
                }
            }
            wallDown();
        }
    }

    static public void wallDown(){
        for (int i=N-1; i>=0; i--) {
            for (int j=0; j<N; j++) {
                if (map[i][j] == '#') {
                    map[i][j] = '.';
                    if (i != N-1) {
                        map[i+1][j] = '#';
                    }
                }
            }
        }
    }

    static public boolean foundWall(){
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j] == '#')
                    return true;
            }
        }
        return false;
    }
}