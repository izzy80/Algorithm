import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
연속된 수들의 부분합 중에 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] A= new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        //투 포인터
        int min = Integer.MAX_VALUE;

        int start =0;
        int end = 0;
        int sum = A[0];
        while(start <= end && end < N){
            if(sum < S ){
//                System.out.println("start = "+start + ", end = "+end+", sum = "+sum);
                end++;
                if(end < N){
                    sum+=A[end];
                }
            }
            else if(sum >= S){
                min = Math.min(min, end - start+1);
                sum-=A[start++];
            }

        }

        if(min == Integer.MAX_VALUE){
            System.out.println(0);
        }
        else{
            System.out.println(min);
        }
    }
}