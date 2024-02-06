import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); //랜선의 개수
        long N = Integer.parseInt(st.nextToken()); //필요한 랜선의 개수

        long[] L = new long[K]; //랜선의 길이를 담은 배열
        long max = 0;
        for(int i=0; i <K; i++){
            L[i] = Long.parseLong(br.readLine());
            max = Math.max(max,L[i]);
        }

        long start = 1;
        long end = max;

        while(start <= end){
            long mid = (start + end)/2;
            long sum =0;
            for(int i=0; i < K; i++){
                sum += L[i]/mid;
            }
//            System.out.println("cnt = "+cnt +", mid = "+mid);
            if(sum < N){
                end = mid-1;
            }
            else if(sum >= N){
                start = mid+1;
            }
        }

        System.out.println(end);
    }
}