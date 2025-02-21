import java.util.*;
import java.io.*;

/**
 * 상근(Albert), 민혁(Barbara), 선영(Casper), 창영(Dinko), 현진(Eustahije)
 * N*N
 * 모든 칸은 비어있음
 * 번갈아가면서 자신의 영어 이름의 첫 글자를 빈 칸에 적음
 * 세 글자가 행, 열, 또는 대각선으로 연속 -> 그 플레이어 승리. 게임 끝
 *
 * 승리하면 이름 첫 글자 출력
 * 아니면 ongoing 출력
 *
 * 승리한 사람은 0 또는 1
 */
public class Main {
    static int N;
    static char[][] map;
    static int[] mover = {-1, 0,1,1};
    static int[] movec = {1,1,1,0};
    static String answer = "ongoing";

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

        // solve
        for(int i=0; i < N; i++){
            for(int j=0; j < N; j++){
                if(map[i][j] != '.'){
                    check(i,j,map[i][j]);
                }
            }
        }

        //print
        System.out.println(answer);
    }

    static public void check(int r, int c, char name){
        for(int m =0; m < 4; m++){
            int nr = r;
            int nc = c;
            int cnt = 1;

            while(true){ //정방향
                nr += mover[m];
                nc += movec[m];

                if(nr < 0 || nr >= N || nc <0 || nc >= N) break;
                if(map[nr][nc] != name) break;
                cnt++;
            }
            nr = r;
            nc = c;

            while(true){
                nr -= mover[m];
                nc -= movec[m];

                if(nr < 0 || nr >= N || nc <0 || nc >= N) break;
                if(map[nr][nc] != name) break;
                cnt++;
            }

            if(cnt >= 3){
                answer = String.valueOf(name);
            }

        }

    }
}