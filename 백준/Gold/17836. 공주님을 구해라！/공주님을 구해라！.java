/*
N,M map
한 칸 이동 시 한 시간
상하좌우 이동 가능
벽은 통과 못 함
명검을 얻으면 마법의 벽이더라도 벽 부수고 갈 수 있다.
이 칼로 부술 수 있는 벽의 개수는 제한이 없다
명검 얻는 순간 벽이 의미 없어짐
0 빈공간
1 마법의 벽
2 그람
T시간 이내에 구출을 못 하면 Fail
 */
import java.util.*;
import java.io.*;

public class Main {
    static boolean[][][] visited;
    static int[][] map;
    static int N,M,T;
    static int[] mover = {0,0,-1,1};
    static int[] movec = {1,-1,0,0};

    static class person {
        int r;
        int c;
        boolean knife;
        int distance;

        public person(int r, int c, boolean knife, int distance){
            this.r = r;
            this.c = c;
            this.knife = knife;
            this.distance = distance;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = BFS(0,0);

        System.out.println(ans == -1? "Fail" : ans);



    }

    private static int BFS(int r, int c) {
        Queue<person> q = new LinkedList<>();
        q.add(new person(r,c,false,0));
        visited[r][c][0] = true;

        while(!q.isEmpty()){
            person p = q.poll();
            if(p.distance > T) break;
            if(p.r == N-1 && p.c == M-1){
                return p.distance;
            }

            for(int m = 0; m < 4; m++){
                int nr = p.r + mover[m];
                int nc = p.c + movec[m];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(p.knife){//칼 있음
                    if(visited[nr][nc][1]) continue;
                    q.add(new person(nr,nc,p.knife,p.distance+1));
                    visited[nr][nc][1] =true;

                }
                else{//칼 없음
                    if(visited[nr][nc][0]) continue;
                    if(map[nr][nc] == 2){
                        q.add(new person(nr,nc, true, p.distance+1));
                    }
                    else if(map[nr][nc] == 0){
                        q.add(new person(nr,nc, p.knife,p.distance+1));
                    }
                    visited[nr][nc][0] = true;
                }



            }

        }
    return -1;
    }
}