import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int I;
    static int[][] map;
    static int[][] dist;

    static StringTokenizer st;

    static int[] mover = new int[]{-1,-2,-2,-1,1,2,2,1};
    static int[] movec = new int[]{-2,-1,1,2,-2,-1,1,2};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            I = Integer.parseInt(br.readLine());

            map = new int[I][I];
            dist = new int[I][I];
            for(int i=0; i<I;i++){
                Arrays.fill(dist[i],-1);
            }

            String st = br.readLine();
            String[] starr = st.split(" ");
            int str = Integer.parseInt(starr[0]);
            int stc = Integer.parseInt(starr[1]);

            String ed = br.readLine();
            String[] edarr = ed.split(" ");
            int edr = Integer.parseInt(edarr[0]);
            int edc = Integer.parseInt(edarr[1]);

            map[str][stc] = 1; // 시작점
            map[edr][edc] = 2; //도착점



            BFS(str, stc);

            System.out.println(dist[edr][edc]);

        }



    }

    private static void BFS(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        dist[r][c] = 0;
        q.add(new int[]{r,c});

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int cr = tmp[0];
            int cc = tmp[1];

            for(int m =0; m<8; m++){
                int nr = cr + mover[m];
                int nc = cc + movec[m];

                if(nr < 0 || nr >= I || nc < 0|| nc >= I) continue;
                if(dist[nr][nc] >= 0) continue;
                dist[nr][nc] = dist[cr][cc]+1;
                q.add(new int[]{nr,nc});
            }
        }
    }
}