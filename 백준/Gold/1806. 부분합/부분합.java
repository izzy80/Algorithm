import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] U = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< N; i++){
            U[i] = Integer.parseInt(st.nextToken());
        }

        //이분탐색
        int start =0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int total = U[0];
        while(start <= end && end < N){
            if(total >= S){
                min = Math.min(min, end - start+1);
                total -= U[start++];
            }
            else{
                end++;
                if(end < N){
                    total += U[end];
                }
            }
//            System.out.println("start = "+start + ", end = "+end+", total = "+total);
        }

        if(min == Integer.MAX_VALUE){
            System.out.println(0);
        }
        else{
            System.out.println(min);
        }
    }
}