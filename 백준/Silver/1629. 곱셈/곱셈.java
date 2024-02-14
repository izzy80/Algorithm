import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static long C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B));
    }

    private static long pow(long a, long b) {
        //지수가 1일 경우 a를 리턴
        if(b == 1) {
            return a % C;
        }
        
        // 지수의 절반에 해당하는 a^(b / 2) 을 구한다.
        long temp = pow(a, b/ 2);
        
        /*
         * 현재 지수가 홀수 였다면
         * a^(b / 2) * a^(b / 2) * a 이므로
         * a를 한 번 더 곱해주어야 한다.
         *
         * ex) a^9 = a^4 * a^4 * a
         */
        if(b % 2 == 1) {
            return (temp * temp % C) * a % C;
        }
        return temp * temp % C;
    }
}