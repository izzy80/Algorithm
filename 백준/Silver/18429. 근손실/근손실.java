import java.util.*;
import java.io.*;

/**
 * 현재 3대 운동 중량 500
 * 하루가 지날때마다 중량 K만큼 감소
 * K=4일 때 3일이 지나면 488로 감소
 * 500 - K*3 = 488
 * 운동을 하지 않는다면 매일매일 중량이 감소만 한다.
 * N개의 서로 다른 운동 키트를 가짐
 * 1개씩 이용 가능 -> 한 번 사용하면 이용 불가능
 * 운동 기간동안 항상 500이상이 유지될 수 있도록 해야함.
 * 가능한 경우의 수를 구하여라
 *
 */

public class Main {
    static int answer = 0;
    static int N,K;
    static int[] exer;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        exer = new int[N];
        check = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++){
            exer[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 500);

        System.out.println(answer);
    }

    public static void dfs(int depth, int cur){
        if(depth == N){
            answer++;
            return;
        }

        for(int i=0; i < N; i++){
            if(check[i]) continue;
            int next = cur+exer[i]-K;
            if(next < 500) continue;
            check[i] = true;
            dfs(depth+1, next);
            check[i] = false;
        }
    }

}