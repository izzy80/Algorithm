import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
산성 용액 : 1~ 1,000,000,000
알칼리성 용액 : -1 ~ -1,000,000,000
이 둘을 혼합하여 0에 가까운 용액을 만들고자 함.
 */

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i< N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 0;
        int end = arr.length -1;
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while(start < end){
            int sum = arr[start] + arr[end];

            if(min > Math.abs(sum)){
                min = Math.abs(sum);
//                System.out.println(min);
                answer[0] = arr[start];
                answer[1] = arr[end];

                if(sum ==0 ) break;
            }

            if(sum < 0){
                start++;
            }
            else if(sum > 0){
                end--;
            }
        }

        //출력
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < answer.length; i++){
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}