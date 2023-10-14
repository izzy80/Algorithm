import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1 : 집이 있는 곳
 * 0 : 집이 없는 곳
 */
public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int cnt;
    static List list;

    static int[] mover = new int[]{-1,0,1,0};
    static int[] movec = new int[]{0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        list = new LinkedList();

        for(int i=0; i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

//        System.out.println(Arrays.deepToString(map));
        cnt =0;
        for(int i =0; i<N;i++){
            for(int j=0; j<N;j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    BFS(i,j);
                }
            }
        }

        System.out.println(cnt);
        list.sort(Comparator.naturalOrder());
        for(int i=0; i<list.size();i++){
            System.out.println(list.get(i));
        }


    }//main

    private static void BFS(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true;
        q.add(new int[]{r,c});
        int area =0;
        cnt++;

        while (!q.isEmpty()){
            int[] tmp = q.poll();
            int cr = tmp[0];
            int cc = tmp[1];

            for(int m=0;m<4;m++){
                int nr = cr+mover[m];
                int nc = cc+movec[m];

                if(nr <0 || nr >= N || nc < 0|| nc >= N) continue;
                if(map[nr][nc] == 0 || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                q.add(new int[]{nr,nc});
            }
            area++;
        }

        list.add(area);

    }
}