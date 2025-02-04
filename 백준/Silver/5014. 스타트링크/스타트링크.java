import java.util.*;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 총 F층
 * 스타트링크 G층
 * 강호는 S층
 * s -> G층으로 이동
 * U : 위로
 * D : 아래로
 * 버튼을 몇 번 눌러야 하는지
 * G층으로 갈 수 없으면 use the stairs
 */
public class Main {
    static int F,S,G,U,D;
    static int[] dist;
    static String answer = "use the stairs";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dist = new int[F+1];
        Arrays.fill(dist, -1);
        //solve
        bfs(S);

        //print
        System.out.println(answer);
    }

    static public void bfs(int idx){
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        dist[idx] = 0;

        while(!q.isEmpty()){
            int now = q.poll();

            if(now == G){
                answer = String.valueOf(dist[now]);
                return;
            }

            for(int i=0; i < 2; i++){
                int next = 0;
                switch (i){
                    case 0:
                        next = now + U;
                        break;
                    case 1:
                        next = now - D;
                        break;
                }

                if(next < 1  || next > F) continue;
                if(dist[next] != -1) continue;
                q.add(next);
                dist[next] = dist[now]+1;
            }
        }



    }
}