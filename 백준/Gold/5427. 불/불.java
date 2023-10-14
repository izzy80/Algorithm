import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int W,H;
    static char[][] map;
    
    static int[][] dist;
    static int[][] distf;

    static Queue<int[]> qf;

    static int[] mover = new int[]{-1,0,1,0};
    static int[] movec = new int[]{0,1,0,-1};
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        int T = Integer.parseInt(br.readLine());

        for(int tc =0; tc < T; tc++){
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new char[H][W];
            dist = new int[H][W];
            distf = new int[H][W];

            for(int i=0; i<H;i++){
                String str = br.readLine();
                for(int j=0; j<W;j++){
                    map[i][j] = str.charAt(j);
                }
            }

            for(int i=0; i<H;i++){
                Arrays.fill(dist[i],-1);
                Arrays.fill(distf[i],-1);
            }

            //불 bfs 먼저 구하기
            qf = new LinkedList<>();
            for(int i=0; i<H;i++){
                for(int j=0; j<W;j++){
                    if(map[i][j] == '*'){
                        distf[i][j] = 0; //불은 여기저기서 날 수 있으니까 이렇게 해야함.
                        qf.add(new int[]{i,j});
                    }
                }
            }
            BFSF();

//            System.out.println(Arrays.deepToString(distf));

            for(int i=0; i<H;i++){
                for(int j=0; j<W;j++){
                    if(map[i][j] == '@'){
                        BFS(i,j);
                    }
                }
            }
//            System.out.println(Arrays.deepToString(dist));

        }//tc
    }

    private static void BFSF() {
        while(!qf.isEmpty()){
            int[] tmp = qf.poll();
            int cr = tmp[0];
            int cc = tmp[1];

            for(int i=0; i<4;i++){
                int nr = cr+mover[i];
                int nc = cc+movec[i];

                if(nr < 0||nr >= H || nc < 0|| nc >= W) continue;
                if(map[nr][nc] =='#'||distf[nr][nc] >=0) continue;

                distf[nr][nc] = distf[cr][cc]+1;
                qf.add(new int[]{nr,nc});
            }
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

            for(int i=0; i<4;i++){
                int nr = cr+mover[i];
                int nc = cc+movec[i];

                if(nr < 0||nr >= H || nc < 0|| nc >= W){
                    System.out.println(dist[cr][cc]+1);
                    return;
                }
                if(map[nr][nc] =='#'  || dist[nr][nc] >= 0) continue;
                if(distf[nr][nc]!=-1 && distf[nr][nc] <= dist[cr][cc]+1) continue;
                dist[nr][nc] = dist[cr][cc]+1;
                q.add(new int[]{nr,nc});


            }
        }
        System.out.println("IMPOSSIBLE");
    }
}