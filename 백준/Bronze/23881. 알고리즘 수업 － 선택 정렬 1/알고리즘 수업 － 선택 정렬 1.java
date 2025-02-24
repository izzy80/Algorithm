import java.util.*;
import java.io.*;

/**
 * N : 배열의 크기
 * K : 교환횟수
 * K번째 교환 되는 두 개의 수
 *
 * 선택 정렬 -> 최소값
 */
public class Main {
    static int N;
    static int[] A;
    static int K;
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        //solve
        selectSort();

        //print
        System.out.println(cnt < K ? -1 : sb.toString());
    }

    public static void selectSort(){
        for (int last = N-1; last >= 0; last--){
            int max = Integer.MIN_VALUE;
            int maxIdx = 0;
            for(int j=0; j <=last; j++){
                if(max < A[j]){
                    max = A[j];
                    maxIdx = j;
                }
            }

            if(last != maxIdx) {
                cnt+=1;
                swap(last,maxIdx);

                if(cnt == K){
                    sb.append(A[maxIdx]).append(" ").append(A[last]);
                    return;
                }
            }


        }
    }
    public static void swap(int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}