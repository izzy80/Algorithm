import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); //조카의 수
        int N = Integer.parseInt(st.nextToken()); //과자의 수
        int[] length = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i=0; i < N; i++){
            length[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, length[i]);
        }

        //solve
        int result = 0;
        int left = 1;
        int right = max;
        while (left <= right) {
            int mid =  left + (right - left) / 2;
            int cnt = 0;

            for (int i = 0; i < length.length; i++) {
                cnt += length[i] / mid;
            }

            if (cnt >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}