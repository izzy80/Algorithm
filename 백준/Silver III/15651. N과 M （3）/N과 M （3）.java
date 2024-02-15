import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] answer;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[M];
        sb = new StringBuilder();

        solve(0);

        //출력
        System.out.println(sb.toString());
    }

    private static void solve(int depth) {
        if(depth == M){
            for(int i=0; i < M; i++){
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 재귀
        for(int i=1; i <= N; i++){
            answer[depth] = i;
            solve(depth+1);
        }
    }
}