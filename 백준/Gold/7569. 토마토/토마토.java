import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
1 : 익은 토마토
0 : 익지 않은 토마토
-1 : 토마토
 */

public class Main {
    static class Point{
        int r;
        int c;
        int h;

        public Point(int h, int r, int c){
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }
    static int M,N,H;
    static int[][][] tomatoBox;
    static int[] mover = {-1,0,1,0,0,0};
    static int[] movec = {0,1,0,-1,0,0};
    static int[] moveh = {0,0,0,0,1,-1};
    static int greenTomato;
    static Queue<Point> redTomato;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomatoBox = new int[H][N][M];
        redTomato = new LinkedList<>();

        for(int i=0; i< H; i++){
            for(int j=0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k =0; k < M; k++){
                    int tmp = Integer.parseInt(st.nextToken());
                    tomatoBox[i][j][k] =  tmp;
                    if(tmp == 0) greenTomato++; //안 익은 토마토
                    if(tmp == 1) redTomato.add(new Point(i,j,k)); //익은 토마토
                }
            }
        }

        //bfs
        bfs();

        //출력
        int max = Integer.MIN_VALUE;
        int answer = -1;
        if(greenTomato  == 0){
            for(int i=0;  i <H; i++){
                for(int j=0; j < N; j++){
                    for(int k=0; k < M; k++){
                        max = Integer.max(max, tomatoBox[i][j][k]);
                    }
                }
            }
            answer = max-1;
        }
        System.out.println(answer);
    }

    private static void bfs() {
        while(!redTomato.isEmpty()){
            Point tmp = redTomato.poll();
            int h = tmp.h;
            int r = tmp.r;
            int c = tmp.c;

            for(int m =0; m <6; m++){
                int nh = h + moveh[m];
                int nr = r + mover[m];
                int nc = c + movec[m];
                if(nr <0 || nr >= N || nc < 0 || nc >= M || nh < 0 || nh >= H) continue;
                if(tomatoBox[nh][nr][nc] == 0){
                    redTomato.add(new Point(nh,nr,nc));
                    greenTomato--;
                    tomatoBox[nh][nr][nc] = tomatoBox[h][r][c]+1;
                }
            }
        }
    }
}