import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][] cloud;
    static int[] mover = {0,-1,-1,-1,0,1,1,1};
    static int result = 0;
    static int[] movec = {-1,-1,0,1,1,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        cloud = new boolean[N][N];
        cloud[N - 1][0] = cloud[N - 1][1] = cloud[N - 2][0] = cloud[N - 2][1] = true;
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            simulation(d - 1, s % N);
        }

        result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += map[i][j];
            }
        }

        System.out.println(result);
    }

    public static void simulation(int direction, int speed) {
        boolean next[][] = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cloud[i][j]) {
                    int nx = (N + i + mover[direction] * speed) % N;
                    int ny = (N + j + movec[direction] * speed) % N;
                    next[nx][ny] = true;
                    map[nx][ny]++;
                }
            }
        }
        cloud = next;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cloud[i][j]) {
                    for (int d = 1; d < 8; d += 2) {
                        int nx = i + mover[d];
                        int ny = j + movec[d];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                            continue;
                        }
                        if (map[nx][ny] > 0) {
                            map[i][j]++;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cloud[i][j]) {
                    cloud[i][j] = false;
                } else if (map[i][j] >= 2) {
                    map[i][j] -= 2;
                    cloud[i][j] = true;
                }
            }
        }
    }
}