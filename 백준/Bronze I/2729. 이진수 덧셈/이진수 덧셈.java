import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb;
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            BigInteger Anum = new BigInteger(A, 2);
            BigInteger Bnum = new BigInteger(B, 2);

            BigInteger sum = Anum.add(Bnum);

            String answer = sum.toString(2);

            //출력
            System.out.println(answer);
        }

    }
}