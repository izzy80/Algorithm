import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        sb = new StringBuilder();
        sb.append((int) (Math.pow(2, N) - 1)).append('\n');
        hanoi(N,1,2,3);
        System.out.println(sb.toString());
    }

    private static void hanoi(int n, int from, int mid, int to) {
        if(n == 1){
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        hanoi(n-1,from,to,mid);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n-1, mid, from, to);
    }
}