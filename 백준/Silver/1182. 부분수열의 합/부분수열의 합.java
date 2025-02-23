import java.util.*;
import java.io.*;

/**
 * N개의 숫자가 주어짐
 * 숫자 일부분을 더해서 S가 되어야함
 * 그 경우의 수를 구해라
 * 근데 N이 이제 20개 -> dfs 완전탐색 가능
 *
 */
public class Main {
    static int N,S;
    static int[] arr;
    static int answer =0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++){
            arr[i] =  Integer.parseInt(st.nextToken());
        }

        dfs(0,0, false);

        System.out.println(answer);

    }

    public static void dfs(int depth, int curSum, boolean isSelected){
        if (depth == N) {  // 모든 원소를 확인한 경우
            if (isSelected && curSum == S) { // 최소 한 개의 원소를 선택한 경우만 카운트
                answer++;
            }
            return;  // 탐색 종료
        }

        dfs(depth + 1, curSum + arr[depth], true);
        dfs(depth + 1, curSum, isSelected);
    }

}