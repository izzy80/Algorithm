import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int N,M;

    static boolean[][] visited;
    static int[] mover = new int[]{-1,0,1,0};
    static int[] movec = new int[]{0,1,0,-1};
    static int[][] map;

    static int[][] copymap;

    static int areacnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copymap = new int[N][M]; //녹아야하는 빙하 높이 cnt

        for(int i=0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j< M; j++){
                map[i][j] =  Integer.parseInt(st.nextToken());
            }
        }
//        System.out.println(Arrays.deepToString(map));

        boolean isiceberzero = false;
        int year = 0;

        while(!isiceberzero){
            visited = new boolean[N][M];
            //1. 지역 개수 세기
            areacnt =0;
            for(int i=0; i<N;i++){
                for(int j=0; j<M;j++){
                    if(!visited[i][j] && map[i][j]!=0){
                        BFS(i,j);
                    }
                }
            }
//            System.out.println(year+"년 빙산 지역 개수 : "+areacnt);
            if(areacnt >= 2) {
                System.out.println(year);
                break;
            }

            //2. 1년 지나면 얼음 녹이기
            year++;
            year();

            //3. 빙하가 다 녹았는지 세기
            isiceberzero = isIceberZero();
        }

        //출력
        if(areacnt < 2){
            System.out.println(0);
        }


    }//main

    private static void BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        q.add(new int[]{i,j});
        areacnt++;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int cr = tmp[0];
            int cc = tmp[1];

            for(int m=0; m< 4; m++){
                int nr = cr+mover[m];
                int nc = cc+movec[m];

                if(nr <0 || nr >= N || nc <0 || nc >= M) continue;
                if(visited[nr][nc] || map[nr][nc] == 0) continue;
                visited[nr][nc]=true;
                q.add(new int[]{nr,nc});

            }
        }
    }

    private static boolean isIceberZero() {
        int cnt =0;
        int len = N*M;
        boolean ans = false;
        for(int i=0; i<N; i++){
            for(int j=0; j<M;j++){
                if(map[i][j] == 0){
                    cnt++;
                }
            }
        }
        if(cnt == len) ans = true;
        //만약 0인 개수와 총 map의 개수가 같다면 다 바다가 되어버린 것
        return ans;
    }

    private static void year() {
        for(int i=0; i<N;i++){
            for(int j=0; j<M; j++){
                if(map[i][j] != 0){
                    //0이 아닌 곳은 아직 빙하가 녹지 않은 곳
                    int r = i;
                    int c = j;
                    int burgcnt = 0;
                    for(int m=0;m<4;m++){
                        //사방탐색하면서 주변 바다의 개수 체크!
                        int nr = r+mover[m];
                        int nc = c+movec[m];
                        if(nr <0 || nr >= N || nc <0 ||nc >= M) continue;
                        if(map[nr][nc] == 0) burgcnt++;
                    }
                    copymap[r][c] = burgcnt;
                }
            }
        }
        //빙하 녹이기
        for(int i=0; i<N; i++){
            for(int j=0; j<M;j++){
                if (map[i][j] - copymap[i][j] <= 0){
                    //주변의 바다개수로 뺀 값이 0보다 작으면 0으로 한다.
                    map[i][j] = 0;
                }
                else{
                    map[i][j]-= copymap[i][j];
                }
            }
        }
    }//year 함수
}