import java.util.*;
import java.io.*;

public class Main {
    static final int N = 19;
    static final int EMPTY = 0;
    static final int BLACK = 1;
    static final int WHITE = 2;
    static int answer = 0;

    static int[] mover = {0,1,1,-1};
    static int[] movec = {1,0,1,1};

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[N][N];

        StringTokenizer st;
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //solve
        int answerr = 0;
        int answerc = 0;
        outer : for(int j=0; j < N; j++){
            for(int i=0; i < N; i++){
                if(map[i][j] == EMPTY) continue;
                if(check(i,j,map[i][j])){
                    answerr = i+1;
                    answerc = j+1;
                    break outer;
                }
            }
        }
        System.out.println(answer);
        if(answer != 0){
            System.out.println(answerr + " "+answerc);
        }
    }

    public static boolean check(int r, int c, int color){
        boolean result = false;

        for(int m=0; m < 4; m++){
            int cnt = 1; //바둑의 갯수
            int cr = r;
            int cc = c;

            //정방향으로 이동
            while(true){
                cr += mover[m];
                cc += movec[m];
                if(cr >= N || cc >= N || cr <0 || cc < 0 ) break;
                if(map[cr][cc] != color) break;
                cnt++;
            }

            //반대방향으로 탐색
            cr = r;
            cc = c;
            while(true){
                cr -= mover[m];
                cc -= movec[m];
                if(cr >= N || cc >= N || cr <0 || cc < 0 ) break;
                if(map[cr][cc] != color) break;
                cnt++;
            }
            if(cnt == 5){
                if(color == BLACK) answer = 1;
                if(color == WHITE) answer = 2;
                result = true;
            }
        }

        return result;
    }
}