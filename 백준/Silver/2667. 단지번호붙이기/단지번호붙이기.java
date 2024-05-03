import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int cnt;
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i < N; i++){
            String str = br.readLine();
            for(int j =0; j < N; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        //solve
        int totalCnt = 0;
        ArrayList<Integer> order = new ArrayList<>();

        for(int i=0; i < N; i++){
            for(int j=0; j < N; j++){
                if(!visited[i][j] && map[i][j] != 0){
                    cnt = 0; //초기화
                    BFS(i,j,map[i][j]);
                    totalCnt++;
                    order.add(cnt);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(totalCnt).append("\n");
        Collections.sort(order);
        for(int value : order){
            sb.append(value).append("\n");
        }

        //출력
        System.out.println(sb.toString());
    }

    static public void BFS(int r, int c, int type){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int cr = tmp[0];
            int cc = tmp[1];
            cnt++;

            for(int m =0; m < 4; m++){
                int nr = cr+mover[m];
                int nc = cc+movec[m];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == type){
                    q.add(new int[]{nr,nc});
                    visited[nr][nc] = true;
                }


            }
        }
    }
}