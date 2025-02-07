import java.util.*;
import java.io.*;

/**
 * pt를 한 번 받을 때 운동기구 최대 2개까지만 선택 가능
 * 향빈이는 운동기가 한 번씩 다 사용해보고 싶음.
 * 이전에 사용하지 않았던 운동기구 선택
 * pt 한 번 받을 때 근손실M을 넘고 싶어하지 않음
 * M의 최솟값을 구해보자
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for(int i=0; i < N; i++){
            arr[i] =  Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long max = Long.MIN_VALUE;
        if(N % 2 == 0){
            for(int i=0; i < N/2; i++){
//                System.out.println(i);
                int start = i;
                int end = (N-1)-i;
//                System.out.println(start+" , "+end);
                long sum = arr[start]+arr[end];
                max = Math.max(max, sum);
            }
            System.out.println(max);
        }
        else{
            for(int i=0; i < (N-2)/2; i++){
                int start = i;
                int end = (N-2)-i;
//                System.out.println(start+" , "+end);
                long sum = arr[start]+arr[end];
                max = Math.max(max, sum);
            }
            max = Math.max(max,arr[N-1]);
            System.out.println(max);
        }
    }
}