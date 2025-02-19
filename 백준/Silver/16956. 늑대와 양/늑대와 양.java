import java.util.*;
import java.io.*;

/**
 * 양은 이동하지 않고 위치를 지킴
 * 늑대는 인접한 칸을 자유롭게 이동
 * 울타리를 설치해 늑대가 양이 있는 칸으로 갈 수 없다면 1, 있다면 0
 * . : 빈칸
 * S : 양
 * W : 늑대
 * D : 울타리
 *
 */
public class Main {
    static final char SHEEP = 'S';
    static final char WOLF = 'W';
    static final char FENCE = 'D';
    static final char EMPTY = '.';

    static int N, M;
    static char[][] map;

    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        int wolf_cnt = 0;
        for(int i=0; i <N; i++){
            String str = br.readLine();
            for(int j=0; j < M; j++){
                char c = str.charAt(j);
                map[i][j] = c;
                if(c == 'W') wolf_cnt++;
            }
        }

        //solve
        for(int i=0; i < N; i++){
            for(int j=0; j < M; j++){
                if(map[i][j]==WOLF){
                    if(!bfs(i,j)){
                        System.out.println(0);
                        return;
                    }
                }
            }
        }
        System.out.println(1);

        //print
        for(int i=0; i < N; i++){
            for(int j=0; j < M; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean bfs(int r, int c){
        for(int m=0; m <4; m++) {
            int nr = r + mover[m];
            int nc = c + movec[m];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if (map[nr][nc] == EMPTY) {
                map[nr][nc] = FENCE;
            }
            if(map[nr][nc] == SHEEP){
                return false;
            }
        }

        return true;
    }
}