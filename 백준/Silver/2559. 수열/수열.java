import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //온도를 측정한 전체 날짜의 수
        int K = Integer.parseInt(st.nextToken()); //합을 구하기 위한 연속적인 날짜의 수

        int[] day = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++){
            day[i] = Integer.parseInt(st.nextToken());
        }



        int s = 0;
        for(int i=0; i < K; i++){
            s += day[i];
        }

        int answer = s;

        int start = 0;
        int end = K;
        while(end < N){
            s -= day[start];
            s += day[end];

            answer = Math.max(answer, s); // 최대값 갱신
            start++;
            end++;
        }

        System.out.println(answer);


    }
}