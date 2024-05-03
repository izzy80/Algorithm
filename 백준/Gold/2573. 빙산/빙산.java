import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[] mover = {-1,1,0,0};
    static int[] movec = {0,0,-1,1};
    static int icebergCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //solve
        int year = 0;
        boolean flag = false;

        while(true){
//            System.out.println("year = "+year);
//            System.out.println(Arrays.deepToString(map));
            //1. 빙산의 수 센다
            countIce();
            //2. 빙산의 수가 없으면 return
            if(icebergCnt == 0) break;
            //3. 빙산의 개수 세기
            int groupIce = 0;
            visited = new boolean[N][M];
            for(int i=0; i < N; i++){
                for(int j=0; j < M; j++){
                    if(map[i][j]!=0 && !visited[i][j]){
                        BFS(i,j);
                        groupIce++;
                    }
                }
            }
//            System.out.println(groupIce);
            //4. 빙산의 갯수가 2개 이상이면 멈춤
            if(groupIce >= 2) {
                flag = true;
                break;
            }
            //5. 얼음 갱신하기
            int[][] zero = new int[N][M];
            for(int i=0;i < N; i++){
                for(int j=0; j < M; j++){
                    int zeroCnt =0;
                    if(map[i][j] !=0){
                        for(int m = 0; m < 4; m++) {
                            int ni = i + mover[m];
                            int nj = j + movec[m];

                            if (ni < 0 || ni >= N || nj < 0 || nj >= M) continue;
                            if (map[ni][nj] == 0) zeroCnt++;
                        }
                        zero[i][j] = zeroCnt;
                    }
                }
            }
            //갱신
            for(int i=0; i < N; i++){
                for(int j=0; j < M; j++){
                    if(map[i][j] !=0){
                        if(map[i][j] - zero[i][j] >= 0){
                            map[i][j] -= zero[i][j];
                        }
                        else{
                            map[i][j] = 0;
                        }
                    }
                }
            }

            //6. 년도 증가
            year++;
        }

        System.out.println(flag?year : 0);



    }
    static public void countIce(){
        icebergCnt = 0;
        for(int i = 0; i < N; i++){
            for(int j=0; j < M; j++){
               if(map[i][j] != 0) icebergCnt++;
            }
        }
    }

    static public void BFS(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int cr = tmp[0];
            int cc = tmp[1];

            for(int m= 0; m <4; m++){
                int nr = cr + mover[m];
                int nc = cc + movec[m];

                if(nr < 0|| nr >= N || nc < 0 || nc >= M) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 0) continue;
                q.add(new int[]{nr,nc});
                visited[nr][nc] = true;
            }
        }
    }
}