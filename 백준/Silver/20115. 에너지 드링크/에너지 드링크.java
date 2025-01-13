import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] drink = new int[N];
        for(int i=0; i < N; i++){
            drink[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(drink);

        double answer = drink[N-1];
        for(int i = N-2; i >= 0; i--){
            answer += (double)drink[i]/2;
        }

        System.out.println(answer);
    }

}