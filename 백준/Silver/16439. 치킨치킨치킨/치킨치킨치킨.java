import java.util.*;
import java.io.*;

/**
 * N명의 고리 회원이 치킨을 주문함
 * 치킨은 M가지 종류
 * 회원마다 특정 치킨에 선호도가 다름
 * 한 사람의 만족도는 시킨 치킨 중 선호도가 가장 큰 값으로 결정
 * 회원들의 만족도의 합이 최대가 되도록 하라
 * 종류는 3가지만 고를 수 있음
 *
 */
public class Main {
    static int N; //고리 회원의 수
    static int M; //치킨의 종류
    static int[][] fav;
    static int answer = Integer.MIN_VALUE;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fav = new int[N][M];
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < M; j++){
                fav[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check = new boolean[M];
        dfs(0);

        System.out.println(answer);
    }

    static public void dfs(int depth){
        if(depth == 3){
            int score = 0;
            for(int i=0; i < N; i++){
                int max = 0;
                for(int j=0; j < M; j++){
                    if(check[j]){
                        //선택한 치킨일때
                        max = Math.max(fav[i][j], max);
                    }
                }
                score+= max;
            }

            answer = Math.max(answer, score);
            return;
        }

        for(int i=0; i < M; i++){
            if(check[i]) continue;
            check[i] = true;
            dfs(depth+1);
            check[i] = false;
        }
    }
}