import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        //풀이
        sb.append((int) (Math.pow(2, K) - 1)).append('\n');

        Hanoi(K, 1, 2, 3);

        //출력
        System.out.println(sb);
    }
    public static void Hanoi(int N, int start, int mid, int to) {
        // 이동할 원반의 수가 1개라면?
        if (N == 1) {
            sb.append(start + " " + to + "\n");
            return;
        }
        Hanoi(N - 1, start, to, mid);
        sb.append(start + " " + to + "\n");
        Hanoi(N - 1, mid, start, to);
    }
}