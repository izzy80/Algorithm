import java.util.*;
import java.io.*;
import java.util.LinkedList;

/**
 * 두 덩어리 이상 분리되지 않으면 0 출력
 * 두 덩어리 이상으로 분리되는 최초의 시간
 * 주변에 0으로 둘러쌓여 있으면 그만큼 빙산이 줄어들음
 */
public class Main {
    static int N,M;
    static int[][] ices;
    static int[][] zero; //주변에 0의 개수
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //행
        M = Integer.parseInt(st.nextToken()); //열

        ices = new int[N][M];

        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < M; j++){
                ices[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        System.out.println(Arrays.deepToString(ices));

        //solve
        int time = 0;
        while(true){
            int ice_cnt = check_ice_cnt();
//            System.out.println(ice_cnt);
            if(ice_cnt>= 2){
                //만약 빙산의 갯수가 2개 이상이면
                System.out.println(time);
//                System.out.println("빙산의 갯수 2개 이상");
                break;
            }
            else if(ice_cnt == 0){
                //빙산의 갯수가 0이면
                System.out.println(0);
//                System.out.println("빙산의 갯수 0개");
                break;
            }

            //빙산이 작아짐
            find_near_zero();

            //빙산 녹게함
            ice_melt();

            time++; //시간 지남
        }

    }

    public static void ice_melt(){
        for(int i=0; i < N; i++){
            for(int j=0; j < M; j++){
                ices[i][j] -=  zero[i][j];
                if(ices[i][j] < 0 ) ices[i][j] = 0;
            }

        }
    }

    public static void find_near_zero(){
        zero = new int[N][M];
        for(int i=0; i < N; i++){
            for(int j=0; j < M; j++){
                if(ices[i][j] != 0){
                    int zero_cnt = 0;
                    for(int m=0; m < 4; m++){
                        int nr = i + mover[m];
                        int nc = j + movec[m];
                        if(nr < 0 || nr >= N || nc <0 || nc >= M) continue;
                        if(ices[nr][nc] == 0) zero_cnt++;
                    }
                    zero[i][j] = zero_cnt;
                }
            }

        }
    }

    public static int check_ice_cnt(){
        visited = new boolean[N][M];
        int ice_cnt = 0;
        for(int i=0; i < N; i++){
            for(int j=0; j < M; j++){
                if(ices[i][j] != 0 && !visited[i][j]){
                    //방문하지 않았고, 빙하가 있음
                    bfs(i,j);
                    ice_cnt++;
                }
            }
        }

        return ice_cnt; //빙산의 갯수
    }

    public static void bfs(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int cr = now[0];
            int cc = now[1];

            for(int m=0; m< 4; m++){
                int nr = cr + mover[m];
                int nc = cc + movec[m];

                if(nr < 0 || nr >= N || nc <0 || nc >= M) continue;
                if(visited[nr][nc]) continue;
                if(ices[nr][nc] == 0) continue;
                q.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }

        }

    }
}