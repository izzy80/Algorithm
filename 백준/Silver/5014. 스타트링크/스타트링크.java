import java.util.*;
import java.io.*;

public class Main {
    static int F;
    static int[] move;
    static int ans;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken()); //총 F층
        int S = Integer.parseInt(st.nextToken()); //강호가 있는 곳(시작점)
        int G = Integer.parseInt(st.nextToken()); //스타트링크의 위치(도착점)
        int U = Integer.parseInt(st.nextToken()); //위로 U층 올라감
        int D = Integer.parseInt(st.nextToken()); //아래로 D층 내려감

        move = new int[]{U,-D};
        ans = -1;
        BFS(S,G);
        System.out.println(ans == -1? "use the stairs" : ans);
    }

    static public void BFS(int start, int end){
        Queue<Integer> q = new LinkedList<>();
        visited = new int[F+1];
        Arrays.fill(visited, -1);
        q.add(start);
        visited[start] = 0;


        while(!q.isEmpty()){
            int tmp = q.poll();
            if(tmp == end){
                ans = visited[end];
                return;
            }

            for(int m = 0; m < 2; m++){
                int nr = tmp + move[m];

                if(nr < 1 || nr > F) continue;
                if(visited[nr] != -1) continue;
                q.add(nr);
                visited[nr] = visited[tmp]+1;
            }
        }

    }
}