import java.util.*;
import java.io.*;

public class Main {
    static int ans;
    static int[] move = {-1,1};
    static int[] visited;
    static int val = 100000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new int[val+1];
        BFS(N,K);
        System.out.println(visited[K]);

    }

    static public void BFS(int start, int end){
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(visited, -1);
        q.add(start);
        visited[start] = 0;

        while(!q.isEmpty()){
            int tmp = q.poll();
            if(tmp == end){
                return;
            }

            int next = 0;
            for(int m= 0; m < 2; m++){
                next = tmp+move[m];
                if(checkRange(next)){
                    q.add(next);
                    visited[next] = visited[tmp]+1;
                }
            }
            next = tmp*2;
            if(checkRange(next)){
                q.add(next);
                visited[next] = visited[tmp]+1;
            }
        }

    }

    static public boolean checkRange(int next){
        if(next < 0 || next > val) return false;
        if(visited[next] != -1) return false;
        return true;
    }

}