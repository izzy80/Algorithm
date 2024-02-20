import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] answer;
    static int[] mover = {-1, 1, 0, 0};
    static int[] movec = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        answer = new int[N][M];
        visited = new boolean[N][M];

        int sr = 0;
        int sc = 0;
        for(int i=0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < M; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 2){
                    sr = i;
                    sc = j;
                }
                map[i][j] = tmp;
            }
        }

        BFS(sr,sc);
        
        for(int i=0; i< N; i++){
            for(int j=0; j < M; j++){
                if(!visited[i][j] && map[i][j] != 0){
                    answer[i][j] = -1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0; i< N; i++){
            for(int j=0; j < M; j++){
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void BFS(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int m=0; m <4; m++){
                int nr = tmp[0] + mover[m];
                int nc = tmp[1] + movec[m];

                if(nr <0 || nr >= N || nc < 0 || nc >= M ) continue;
                if(visited[nr][nc] || map[nr][nc] == 0) continue; //이미 방문한 곳과 0인곳은 지나가기
                answer[nr][nc] = answer[tmp[0]][tmp[1]]+1;
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
    }
}