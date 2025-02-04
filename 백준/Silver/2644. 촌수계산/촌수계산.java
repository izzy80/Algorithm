import java.util.*;
import java.io.*;

/**
 * 촌수 계산하기
 */
public class Main {
    static int N;
    static int A, B; //서로 다른 두 사람
    static int M;
    static ArrayList<Integer>[] family;
    static boolean[] visited;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //전체 사람의 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        family = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i <=N; i++){
            family[i] = new ArrayList<Integer>();
        }

        M = Integer.parseInt(br.readLine());
        for(int i=0; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            family[parent].add(child);
            family[child].add(parent);
        }

        //solve
        dfs(A,0);

        //print
        System.out.println(answer);
    }

    public static void dfs(int idx, int depth){
        if(idx == B){
            answer = depth;
            return;
        }

        visited[idx] = true;

        for(int i : family[idx]){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(i, depth+1);
        }
    }
}