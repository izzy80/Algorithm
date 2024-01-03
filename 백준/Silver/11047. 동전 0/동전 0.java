import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];
        for(int i=0; i< N; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        //그리디 알고리즘
        int cnt =0; //필요한 동전의 개수

        while(K > 0){
            for(int i=N-1; i>=0; i--){
                if(K >= coin[i]){
                    //만약 K원이 coin[i]보다 크거나 같으면
                    cnt += K / coin[i];
                    K = K % coin[i];
                }
            }
        }



        System.out.println(cnt);
    }
}