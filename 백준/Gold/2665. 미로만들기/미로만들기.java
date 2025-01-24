import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map, dist;
    static final int INF = 2501; // 충분히 큰 값 설정
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int r, c, cost;
        Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost; // 비용이 적은 순서대로 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
                dist[i][j] = INF; // dist 배열 초기화
            }
        }

        // 다익스트라 실행 후 결과 출력
        System.out.println(dijkstra());
    }

    public static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int cr = now.r;
            int cc = now.c;
            int cost = now.cost;

            if (cost > dist[cr][cc]) continue; // 기존보다 더 큰 비용이면 스킵

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                int nextCost = cost + (map[nr][nc] == 0 ? 1 : 0);

                if (nextCost < dist[nr][nc]) {
                    dist[nr][nc] = nextCost;
                    pq.offer(new Node(nr, nc, nextCost)); // 최소 비용 기준으로 탐색
                }
            }
        }
        return dist[N-1][N-1];
    }
}