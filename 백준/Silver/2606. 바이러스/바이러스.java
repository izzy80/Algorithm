import java.util.*;
import java.io.*;


public class Main {
    static int computerN;
    static ArrayList<Integer>[] graph;
    static int ans;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computerN = Integer.parseInt(br.readLine());
        int pairN = Integer.parseInt(br.readLine());

        StringTokenizer st;
        graph = new ArrayList[computerN+1];
        for(int i=1; i <= computerN; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i < pairN; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        //dfs
        ans = 0;
        visited = new boolean[computerN+1];
        DFS(1);

        //출력
        System.out.println(ans-1);
    }


    static public void DFS(int idx){
        visited[idx] = true;
        ans++;


        for(int next : graph[idx]){
            if(visited[next]) continue;
            DFS(next);
        }


    }

}