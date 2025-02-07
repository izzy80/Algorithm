import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        long answer = -1;
        Queue<long[]>q = new ArrayDeque<>();
        q.add(new long[]{A,1});

        while(!q.isEmpty()){
            long[] tmp = q.poll();
            long now = tmp[0];
            long cnt = tmp[1];
//            System.out.println(now + " ," + cnt);

            if(now == B){
                answer = cnt;
                break;
            }

            if(now * 2 <= B) {
                q.add(new long[]{now * 2, cnt+1});
            }
            if((now*10)+1 <= B){
                q.add(new long[]{(now*10)+1, cnt+1});
            }
        }

        System.out.println(answer);

    }
}