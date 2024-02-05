import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        //정렬
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        int[] Marr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i < M; i++){
            Marr[i] = Integer.parseInt(st.nextToken());
        }

        //이분탐색
        for(int i=0; i < M; i++){
            int findNum = Marr[i]; //찾아야할 숫자
            int find = Arrays.binarySearch(A, findNum);
            if(find < 0){
                System.out.println(0);
            }
            else{
                System.out.println(1);
            }
        }
    }
}