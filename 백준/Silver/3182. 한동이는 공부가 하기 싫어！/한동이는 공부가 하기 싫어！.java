import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int answer = 0;
    static int max_cnt = Integer.MIN_VALUE;;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        for(int i=1; i <= N; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i < N; i++){
            int a = Integer.parseInt(br.readLine());
            arr[i+1].add(a);
        }

        //solve
        for(int i=1; i <= N; i++){
            visited = new boolean[N+1];
            visited[i] = true;
            dfs(i, i,1);
        }

        System.out.println(answer);
    }

    static public void dfs(int first, int cur, int cnt){
        if(cnt > N) return;
        if(max_cnt < cnt){
            max_cnt = cnt;
            answer = first;
        }
        //1. 방문 처리
        for(int value : arr[cur]){
            if(visited[value]) continue;
            visited[value] = true;
            dfs(first, value, cnt+1);
            visited[value] = false;
        }

    }
}