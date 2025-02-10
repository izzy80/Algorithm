import java.util.*;
import java.io.*;

/**
 * 답 : 가장 적은 비용
 * 여기서는 비용이 가중치인가?
 * 왔다가는 비용은 다름
 * 갈 수없으면 비용은 0
 */
public class Main {
    static int N;
    static int[][] map;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        //solve
        answer = Integer.MAX_VALUE;
        for(int i=0; i < N; i++){
            visited = new boolean[N];
            visited[i] = true;
            dfs(i, i, 0, 0);
        }

        //print
        System.out.println(answer);
    }

    public static void dfs(int start,int now, int cost,int depth){
        if (cost >= answer) return; //cost가 이전 경우보다 더 큰 경우 중단
        if(depth == N-1){
            // 모든 도시를 모두 방문한 경우, N-1인 이유는 백트래킹 메서드를 실행하기 전에 이미 방문함
            if(map[now][start] != 0){
                cost += map[now][start];
                answer = Math.min(cost, answer);
            }
            return;
        }

        for(int i=0; i < N; i++){
            if(map[now][i] == 0) continue; //0이면 연결x
            if(visited[i]) continue; //방문했다면 지나가지x
            visited[i] = true;
            dfs(start, i, cost+map[now][i],depth+1);
            visited[i] = false;
        }
    }
}