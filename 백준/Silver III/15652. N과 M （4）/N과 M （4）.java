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

        sb = new StringBuilder();
        answer = new int[M];
        solve( 1,0);
        System.out.println(sb.toString());
    }

    private static void solve(int num, int depth) {
        if(depth == M){
            for(int i=0; i< M; i++){
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = num; i <= N; i++){
            answer[depth] = i;
            solve(i, depth+1);
        }

    }
}