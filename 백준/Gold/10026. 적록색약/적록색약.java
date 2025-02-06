import java.util.*;
import java.io.*;

/**
 * N*N
 * 각 칸은 R,G,B
 * 상하좌우 인접 같은 구역
 * 적록색약인 사람이 봤을 때
 * 적록색약이 아닌 사람이 봤을 때
 */
public class Main {

    static int N;
    static char[][] map;
    static boolean[][] no_visited;
    static boolean[][] yes_visited;
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i=0; i < N; i++){
            String str = br.readLine();
            for(int j=0; j < N; j++){
                map[i][j] = str.charAt(j);
            }
        }

        //solve
        int answer1 = 0;
        int answer2 = 0;
        yes_visited = new boolean[N][N];
        no_visited = new boolean[N][N];
        for(int i = 0; i< N; i++){
            for(int j=0; j < N; j++){
                if(!yes_visited[i][j]){
                    yes_redgreen(i,j,map[i][j]);
                    answer1++;
                }
                if(!no_visited[i][j]){
                    no_redgreen(i,j,map[i][j]);
                    answer2++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer2).append(" ").append(answer1);


        //print
        System.out.println(sb.toString());
    }

    public static void yes_redgreen(int r, int c, char color){
        //적록색약
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r,c});
        yes_visited[r][c] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int cr = now[0];
            int cc = now[1];

            for(int m = 0; m < 4; m++){
                int nr = cr + mover[m];
                int nc = cc + movec[m];

                if(nr < 0 || nr >= N || nc <0 || nc >= N) continue;
                if(yes_visited[nr][nc]) continue;
                if(color == 'R' || color == 'G') {
                    if(map[nr][nc] == 'R' || map[nr][nc] == 'G'){
                        q.add(new int[]{nr,nc});
                        yes_visited[nr][nc] = true;
                    }
                }
                else if(color == 'B'){
                    if(map[nr][nc] == 'B'){
                        q.add(new int[]{nr,nc});
                        yes_visited[nr][nc] = true;
                    }
                }

            }
        }
    }

    public static void no_redgreen(int r, int c, char color){
        //적록색약
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r,c});
        no_visited[r][c] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int cr = now[0];
            int cc = now[1];

            for(int m = 0; m < 4; m++){
                int nr = cr + mover[m];
                int nc = cc + movec[m];

                if(nr < 0 || nr >= N || nc <0 || nc >= N) continue;
                if(no_visited[nr][nc]) continue;
                if(map[nr][nc] != color)  continue;
                q.add(new int[]{nr,nc});
                no_visited[nr][nc] = true;
            }
        }
    }
}