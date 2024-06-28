import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] number = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }


        int answer =0;
        for(int i=0; i<K; i++){
            answer+=number[i];
        }

        int sum = answer;
        for(int i=K; i< N; i++){
            sum = sum - number[i-K]+number[i];
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);


    }
}