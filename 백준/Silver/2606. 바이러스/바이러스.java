import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int computer_cnt;
    static int pair_cnt;
    static int answer;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computer_cnt = Integer.parseInt(br.readLine());
        pair_cnt = Integer.parseInt(br.readLine());

        map = new int[computer_cnt+1][computer_cnt+1];
        StringTokenizer st;
        for(int i = 0; i < pair_cnt; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;
        }

        //solve

        visited = new boolean[computer_cnt+1];
        answer = 0;
        dfs(1);

        // 결과
        System.out.println(answer-1);

    }

    public static void dfs(int depth){
        visited[depth] = true;
        answer++;

        for(int i=1; i <= computer_cnt; i++){
            if(visited[i]) continue; //방문했으면
            if(map[depth][i] == 1) {
                dfs(i);
            }
        }

    }
}