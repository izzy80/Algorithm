import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,S;
    static int answer;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        answer = 0;
        solve(0,0);
        System.out.println(S ==0? answer-1:answer); //공집합 제외
    }

    private static void solve(int depth,int sum) {
        if(depth == N){
            if(sum == S){

                answer++;
            }
            return;
        }

        solve(depth+1, sum+arr[depth]);// 방문했다 안 했다는 그냥 sum에서 처리를 해주는 듯?
        solve(depth+1, sum);
    }
}