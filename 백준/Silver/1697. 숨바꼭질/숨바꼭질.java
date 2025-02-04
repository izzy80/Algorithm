import java.util.*;
import java.io.*;


/**
 * 수빈이는 걷거나 순간이동 가능
 * 걸을 때 X-1 , X+1
 * 순간이동 2*X
 * 수빈이가 동생을 찾을 수 있는 가장 빠른 시간은?
 */
public class Main {
    static int N,K;
    static int[] times = new int[100_000+1];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //수빈이의 위치
        K = Integer.parseInt(st.nextToken()); //동생의 위치

        //solve
        bfs(N);

        //print
        System.out.println(answer);
    }


    public static void bfs(int idx){
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        Arrays.fill(times,-1);
        times[idx] = 0;

        while(!q.isEmpty()){
            int now = q.poll();

            if(now == K){
                answer = times[K];
                return;
            }

            for(int m=0; m <3; m++){
                int next =0;
                switch (m){
                    case 0:
                        next = now+1;
                        break;
                    case 1:
                        next = now-1;
                        break;
                    case 2:
                        next = now * 2;
                        break;

                }

                if(next < 0 || next > 100_000) continue; //범위에 벗어나면 지나감
                if(times[next] != -1) continue; //방문했다면 지나감

                q.add(next);
                times[next] = times[now]+1;
            }

        }


    }
}