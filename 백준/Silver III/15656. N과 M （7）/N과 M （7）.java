import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] answer;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        answer = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);  // 사전 순으로 증가하는 순서로 출력해야해서

        sb = new StringBuilder();
        solve(0);

        System.out.println(sb.toString());
    }

    private static void solve(int depth) {
        if(depth == M){
            for(int i=0; i< M; i++){
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        //
        for(int i=0; i < N; i++){ //arr의 idx //0일 때 아직 안 집어넣었으니까 +1하면 안 된다.
            answer[depth] = arr[i];
            solve(depth+1);
        }
    }
}