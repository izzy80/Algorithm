import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] graph;
    static int N, M, answer = 0;

    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) { // T번 반복
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            graph = new int[N][M];
            visited = new boolean[N][M];
            ArrayList<int[]> list = new ArrayList<>();
            answer = 0;
            for (int j = 0; j < K; j++) { // 양배추 K개의 위치
                st = new StringTokenizer(br.readLine(), " ");
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph[X][Y] = 1;
                if (graph[X][Y] == 1) {
                    list.add(new int[]{X, Y});
                }
            }
            for (int k = 0; k < list.size(); k++) {
                int[] tmp = list.get(k);
                int x = tmp[0];
                int y = tmp[1];
                if (!visited[x][y]) { // 이미 체크한 양배추가 아닐 경우에만 bfs메서드 실행
                    bfs(x, y);
                    answer++;
                }
            }
            System.out.println(answer);

        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int x, int y) {
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (graph[nx][ny] == 1) {
                        if (!visited[nx][ny]) {
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }
}