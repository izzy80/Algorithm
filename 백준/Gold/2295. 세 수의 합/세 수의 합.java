import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        //1. 입력 값
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] U = new int[N];
        for(int i=0; i< N; i++){
            U[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(U);

        //2. 중복이 가능하므로 가능한 경우의 수는 모두 N*N
        int[] sum = new int[N*N];
        int idx = 0;
        for(int i=0; i< N; i++){
            for(int j = 0; j< N; j++){
                sum[idx++] = U[i]+U[j];
            }
        }
        Arrays.sort(sum);
//        System.out.println(Arrays.toString(sum));

        //3. 이분 탐색
        /*
            U[x] + U[y] + U[z] = U[k]
            -> U[x] + U[y] = U[k] - U[z]
            -> sum[?] = U[k] - U[z]
            U의 차가 sum 배열에 있는지!
         */
      
        int answer = 0;
        outer : for(int i=N-1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(Arrays.binarySearch(sum, U[i] - U[j]) >= 0) { //음수로 반환하면 없다는 것
                    answer= U[i];
                    break outer;
                }
            }
        }
        System.out.println(answer);
    }
}