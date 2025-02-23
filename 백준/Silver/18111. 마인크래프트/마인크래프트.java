import java.util.*;
import java.io.*;
/**
 * 땅고르기 작업에 걸리는 최소 시간과 그 경우 땅의 높이를 구하여라
 * 인벤토리에 B개의 블록이 있음
 * 땅의 높이는 256블록을 초과할 수 없고, 음수가 될 수도 없다.
 * 세로X, 가로 M
 * 집터 맨 왼쪽의 위치는 (0,0)
 * 1. 좌표 (i,j)의 가장 위에 있는 블록을 제거해 인벤토리에 넣는다. -> 2초
 * 2. 인벤토리에서 블록 하나를 꺼내서 좌표(i,j)의 가장 위에 있는 블록 위에 놓는다. -> 1초
 *
 */
public class Main {
    static int N,M,B;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        int max = 0;
        int min = 0;
        for(int i=0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int tmp =  Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                max = Math.max(max,map[i][j]);
                min = Math.min(min,map[i][j]);
            }
        }

        //solve
        int answerTime = Integer.MAX_VALUE;
        int answerH = 0;
        for(int i=max; i >= min; i--){
            int time = 0;
            int block = B;
            for(int j=0; j < N; j++){
                for(int k=0; k < M; k++){
                    if(i < map[j][k]){
                        int diff = Math.abs(i-map[j][k]);
                        time +=2*diff;
                        block += diff;
                    }
                    else if(i > map[j][k]){
                        int diff = Math.abs(i-map[j][k]);
                        time += diff;
                        block -= diff;
                    }
                }
            }
            if(answerTime > time) {
                if(block >= 0){
                    answerTime = time;
                    answerH = i;
                }
            }
        }

        System.out.println(answerTime +" "+answerH);


    }
}