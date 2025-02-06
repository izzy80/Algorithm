import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); //기준값
        int X = Integer.parseInt(st.nextToken()); //초기레이팅

        int[] A = new int[N+1];
        st = new StringTokenizer(br.readLine());

        int[] islower = new int[N+1];
        int[] sum = new int[N+1];
        int nownumber = X;
        for(int i=1; i <= N; i++){
            A[i] = Integer.parseInt(st.nextToken()); //수열
            nownumber += A[i];
            if(nownumber < K) islower[i]++;
            sum[i] = sum[i-1]+islower[i];
        }
//        System.out.println(Arrays.toString(islower));
//        System.out.println(Arrays.toString(sum));

        for(int i=0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int answer = 0;
            if (islower[start] == 1)
                answer = sum[end-1]-sum[start] + 1;
            else
                answer = sum[end-1]-sum[start];

            sb.append(answer).append("\n");

        }
        System.out.println(sb.toString());
    }
}