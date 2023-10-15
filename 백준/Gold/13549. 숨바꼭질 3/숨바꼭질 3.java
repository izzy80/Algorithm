import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    static int[] dist = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Arrays.fill(dist,-1);
        N = Integer.parseInt(st.nextToken()); //수빈의 위치
        K = Integer.parseInt(st.nextToken()); //동생의 위치

        BFS(N);


    }

    private static void BFS(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        dist[n] = 0;

        while(!q.isEmpty()){
            int cl = q.poll();
            if(cl == K) {
                System.out.println(dist[cl]);
                return;
            }

            if(cl*2 <= 100000 &&dist[cl*2] == -1){
                dist[cl*2] = dist[cl];
                q.add(cl*2);
            }
            if(cl-1 >=0 &&dist[cl-1] == -1){
                dist[cl-1] = dist[cl]+1;
                q.add(cl-1);
            }
            if(cl+1 <= 100000 &&dist[cl+1] == -1){
                dist[cl+1] = dist[cl]+1;
                q.add(cl+1);
            }

        }


    }
}