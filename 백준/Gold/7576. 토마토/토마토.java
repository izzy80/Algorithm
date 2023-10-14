import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 토마토가 위치한 곳은 동시에 토마토가 익어야함.
 */
public class Main {
    static int N,M;
    static int[][] map;
    static int[][] dist;

    static int[] mover = new int[]{-1,0,1,0};
    static int[] movec = new int[]{0,-1,0,1};
    static StringTokenizer st;
    static int max;
    static int zero;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;

        map = new int[M][N];
        dist= new int[M][N];
        for(int i=0; i<M;i++){
            Arrays.fill(dist[i],-1);
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

//        System.out.println(Arrays.deepToString(map));
        BFS();



        int nam = 0; //남은 토마토
        for(int i=0; i< M;i++){
            for(int j=0; j <N; j++){
                if(map[i][j] == 0){
                    nam++;
                }
            }
        }

       if(nam>0){
//            System.out.println(nam);
            System.out.println(-1);
        }
        else{
            for(int i=0; i<M;i++){
                for(int j=0; j <N;j++){
                    max = Integer.max(dist[i][j],max);
                }
            }
            System.out.println(max);
        }

    }

    private static void BFS() {
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i< M;i++){
            for(int j=0; j <N; j++){
                if(map[i][j] == 1){
                    q.add(new int[]{i,j});
                    dist[i][j] = 0;
                }
            }
        }

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int cr = tmp[0];
            int cc = tmp[1];

            for(int m =0; m< 4;m++){
                int nr = cr + mover[m];
                int nc = cc + movec[m];

                if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
                if(dist[nr][nc]!=-1) continue;
                if(map[nr][nc] == 0){
                    map[nr][nc] = 1;
                    dist[nr][nc] = dist[cr][cc]+1;
                    q.add(new int[]{nr,nc});
                }
            }
        }

    }
}