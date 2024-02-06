import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    static int[] A;
    static int N;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        visited = new boolean[N];
        for(int i=0; i< N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        int[] sum = new int[N*N];
        int idx = 0;
        for(int i=0; i< N; i++){
            for(int j = 0; j< N; j++){
                sum[idx++] = A[i]+A[j];
            }
        }
        Arrays.sort(sum);

//        System.out.println(Arrays.toString(sum));

        //이분 탐색
        int max = Integer.MIN_VALUE;

        for(int i=N-1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(Arrays.binarySearch(sum, A[i] - A[j]) >= 0){
                    max = Integer.max(max, A[i]);
                }
                    //0보다 크다는 것은 있다는 것
            }
        }
        System.out.println(max);



    }
}