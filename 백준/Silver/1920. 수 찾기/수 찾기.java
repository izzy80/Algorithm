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

            int answer = 0;
            int start =0;
            int end = A.length-1;
            while(start <= end){
                int mid = (end+start)/2;

                if(A[mid] == findNum){
                    answer = 1;
                    break;
                }
                else if(A[mid] > findNum){ //찾는 숫자보다 중간값이 크다면,
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            System.out.println(answer);
        }


    }
}