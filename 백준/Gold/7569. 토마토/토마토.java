import java.util.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
/*
0 : 익지 않은 토마토
1: 익은 토마토
-1 : 토마토 없음

토마토가 모두 익을때까지 최소 며칠?
저장될 때부터 모든 토마토가 익음 -> 0
토마토가 모두 익지 않음 -> -1
 */

public class Main {
    static int M, N, H;
    static int[][][] tomatoes;
    static int[][][] visited;

    static int[] mover = {0,0,1,-1,0,0};
    static int[] movec = {1,-1,0,0,0,0};
    static int[] moveh = {0,0,0,0,1,-1};
    static Queue<int[]> q = new LinkedList<>();
    static int day = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomatoes = new int[N][M][H];
        visited = new int[N][M][H];
        for(int i = 0; i < H; i++){
            for(int r = 0; r < N; r++){
                for(int c = 0; c < M; c++){
                    visited[r][c][i] = -1;
                }
            }
        }

        int cnt = 0;
        int zero_tomato = 0;
        for(int i = 0; i < H; i++){
            for(int r = 0; r < N; r++){
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < M; c++){
                    int tmp = Integer.parseInt(st.nextToken());
                    tomatoes[r][c][i] = tmp;
                    if(tmp == 1){
                        cnt++;
                        q.add(new int[]{r,c,i});
                        visited[r][c][i] = 0;
                    }
                    else if(tmp == 0){
                        zero_tomato++;
                    }
                }
            }
        }

//        System.out.println(Arrays.deepToString(tomatoes));


        if(zero_tomato == 0){
            System.out.println(0);
            return;
        }
        else{
            BFS();
//            System.out.println(Arrays.deepToString(tomatoes));
            for(int i = 0; i < H; i++){
                for(int r = 0; r < N; r++){
                    for(int c = 0; c < M; c++){
                        if(tomatoes[r][c][i] == 0){
                            System.out.println(-1);
                            return;
                        }
                    }
                }
            }

            System.out.println(day);
        }

    }

    public static void BFS(){

        while(!q.isEmpty()){
            int[] now = q.poll();
            int cr = now[0];
            int cc = now[1];
            int ch = now[2];

            for(int m=0; m < 6; m++){
                int nr = cr + mover[m];
                int nc = cc + movec[m];
                int nh = ch + moveh[m];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || nh < 0 || nh >= H) continue;
                if(visited[nr][nc][nh] != -1) continue; //방문했다면 지나감
                if(tomatoes[nr][nc][nh] == 0){
                    q.add(new int[]{nr,nc,nh});
                    visited[nr][nc][nh] = visited[cr][cc][ch]+1;
                    tomatoes[nr][nc][nh] = 1;
                    day = Math.max(day, visited[nr][nc][nh]);
                }
            }
        }
    }
}