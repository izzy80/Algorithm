import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] rope = new int[N];
        for(int i=0; i< N; i++){
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope); //오름차순 정렬

        int cnt =0;
        int max =0;
        int sum =0;
        for(int i=N-1; i>=0; i--){
            cnt++;
            sum = rope[i]*cnt;

            if(max < sum){
                max = sum;
            }

        }

        System.out.println(max);
    }//main
}