import java.util.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int ans = 0;
    static boolean[] visited = new boolean[100000+1];
    static int K;
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //수빈이의 위치
        K = Integer.parseInt(st.nextToken()); //동생의 위치
        BFS(N);

        System.out.println(ans);
    }
    static public void BFS(int N){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{N, 0});
        visited[N] = true;

        while(!q.isEmpty()){
            int[] tmp  = q.poll();
            int pos = tmp[0];
            int time = tmp[1];


            if(pos == K){
                ans = time;
                break;
            }

            if(pos*2 <= 100000 && !visited[pos*2]){
                q.offer(new int[]{pos*2, time});
                visited[pos*2] = true;
            }
            if(pos-1 >= 0 && !visited[pos-1]){
                q.offer(new int[]{pos-1, time+1});
                visited[pos-1] = true;
            }
            if(pos+1 <= 100000 && !visited[pos+1]){
                q.offer(new int[]{pos+1, time+1});
                visited[pos+1] = true;
            }
        }

    }
}