import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] S = new int[N+1];
        int[] D = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<= N; i++){
            S[i] = Integer.parseInt(st.nextToken()); //섞은 카드
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<= N; i++){
            D[i] = Integer.parseInt(st.nextToken()); //이동X
        }
        int[] answer = new int[N+1];

        //풀이
        while(K!=0){
            for(int i=1; i<= N; i++) {
                answer[D[i]] = S[i];
            }
            S = Arrays.copyOf(answer,N+1);
            K--; //횟수 줄여줌
        }


        for(int i=1; i<=N; i++){
            System.out.print(answer[i]+" ");
        }
    }
}