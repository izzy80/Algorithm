import java.util.*;
import java.io.*;

//구간의 점수의 최대값의 최솟값을 구해라
//M개의 최댓값을 구하고 그 중에 가장 작은 값이 답
public class Main {
    static int N, INF = Integer.MAX_VALUE;
    static int[] arr;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = Integer.MIN_VALUE;
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        while(left < right) {
            int mid = (left + right)/2;
            if(solve(mid) <= M) {
                right = mid;
            }else {
                left = mid+1;
            }
        }
        System.out.println(right);
    }

    static int solve(int mid) {
        int cnt = 1;
        int min = INF;
        int max = -INF;
        for(int i=0; i<N; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if(max - min > mid) {
                cnt++;
                max = -INF; min = INF;
                i--;
            }
        }
        return cnt;
    }
}