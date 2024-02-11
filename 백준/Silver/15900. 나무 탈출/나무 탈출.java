import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static int cnt;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];

        for(int i=1; i<= N; i++){
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int a,b;
        for(int i=0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        cnt =0;
        dfs(1,-1,0);

        System.out.println(cnt%2==0?"No":"Yes");
    }

    private static void dfs(int idx, int parent, int depth) {
        if(graph[idx].size() == 1 && graph[idx].get(0) == parent){
            cnt += depth;
//            System.out.println(depth);
            return;
        }
        for (int child : graph[idx]) {
            if(child == parent) continue;
            dfs(child, idx, depth + 1);
        }
    }
}