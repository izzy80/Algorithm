import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//두 수의 차가 M이상이면서 가장 작은 차이를 출력하라
public class Main {
    public static void main(String[] args) throws IOException {
        //1.입력하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //A의 개수
        int M = Integer.parseInt(st.nextToken()); //두 수의 차이

        int[] A = new int[N];
        for(int i=0; i< N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        //정렬
        Arrays.sort(A);

        //투포인터
        int min = Integer.MAX_VALUE;

     
        int end  =0;
        for(int start =0; start < N; start++){
            while(end < N && A[end] - A[start] < M) end++; 
            if(end == N) break; //end가 범위를 벗어난다면 종료
            min = Math.min(min, A[end] - A[start]); 
        }
        
        System.out.println(min);
    }
}