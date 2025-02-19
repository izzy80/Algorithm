import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int length = Math.min(N, M);
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int answer = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int i = 1; i <= length; i++) {
                    if (r + i >= N || c + i >= M) continue;
                    int left_up = map[r][c];
                    int left_down = map[r + i][c];
                    int right_up = map[r][c + i];
                    int right_down = map[r + i][c + i];
                    if (left_up == left_down && left_down == right_up && right_up == right_down)
                        answer = Math.max(i+1, answer);
                }
            }
        }


        System.out.println(answer == 0? 1:answer * answer);

    }
}