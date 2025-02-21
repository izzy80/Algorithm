import java.util.*;
import java.io.*;

/**
 * 크기가 N인 정수형 배열 X가 있을 때
 * X의 부분 배열 중 원소의 합이 가장 큰 부분 배열을 찾아라
 * 단 연속해야함.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T ; tc++){
            int answer = Integer.MIN_VALUE;
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=0; i < N; i++){
                int sum = 0;
                for(int j=i; j < N; j++){
                    sum += arr[j];
                    if(answer < sum) answer = sum;
                }
            }
            System.out.println(answer);
        }
    }
}