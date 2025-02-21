import java.util.*;
import java.io.*;

/**
 * 축구를 하기 위해 모인 사람은 총 N명
 * N은 짝수
 * N/2명으로 이루어진 스타트팀과 링크 팀으로 사람들을 나눠야 한다.
 *
 * 스타트 팀과 링크 팀의 능력치의 차이의 최소값은?
 *
 */
public class Main {
    static int N;
    static int[][] score;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        score = new int[N][N];
        StringTokenizer st;
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < N; j++){
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //solve
        visited = new boolean[N];
        dfs(0,0);


        System.out.println(answer);

    }

    public static void dfs(int idx, int depth){
        if(depth == N/2){
            int startSum =0;
            int linkSum = 0;
            for(int i=0; i < N; i++){
                for(int j=0; j < N; j++){
                    if(i == j) continue;
                    if(visited[i] && visited[j]) startSum += (score[i][j]);
                    if(!visited[i] && !visited[j]) linkSum += (score[i][j]);
                }
            }

            answer = Math.min(answer, Math.abs(startSum-linkSum));
            return;
        }

        for(int i=idx; i < N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(i+1, depth+1);
            visited[i] = false;
        }
    }
}