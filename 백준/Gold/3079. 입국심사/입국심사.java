import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //입국심사대의 개수
        long M = Integer.parseInt(st.nextToken()); //상근이와 친구들의 수
        int[] time = new int[N];
        for(int i=0; i < N; i++){
            time[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(time);

        //풀이
        long left = 0;
        long right = time[N-1]*M; //가장 길때
        long answer =0; // 최소 시간

        while(left <= right){
            long mid = (left+right)/2;

            //계산
            long pass =0; //통과된 사람의 수
            for(int i=0; i < N; i++){
                pass += mid/time[i];

                if(pass >= M) {
                    break;
                }
            }

            if(pass >= M){
                right = mid-1;
                answer = mid;
            }
            else {//사람 수가 M보다 작다면 시간 수를 늘려야함.
                left = mid+1;
            }
        }

        System.out.println(answer);



    }
}