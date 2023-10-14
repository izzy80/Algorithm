import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    static int N;
    static char[][] mmap;
    static char[][] rgmap;

    static boolean[][] visitedm;
    static boolean[][] visitedrg;

    static int[] mover = new int[]{-1,0,1,0};
    static int[] movec = new int[]{0,1,0,-1};

    static int m;
    static int rg;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        mmap = new char[N][N];
        rgmap = new char[N][N];


        visitedm = new boolean[N][N];
        visitedrg= new boolean[N][N];

        for(int i=0; i<N;i++){
           String str = br.readLine();
            for(int j=0; j< N;j++){
                char c = str.charAt(j);
                mmap[i][j] = c;
                rgmap[i][j] = c;
                if(c == 'R'){
                    rgmap[i][j] = 'G';
                }
            }
        }

        m =0;
        rg =0;
        for(int i=0; i<N;i++){
            for(int j=0; j< N;j++){
                if(!visitedm[i][j]){

                    BFS(i,j,mmap,visitedm,1);
                }
                if(!visitedrg[i][j]){

                    BFS(i,j,rgmap,visitedrg,0);
                }
            }
        }

        System.out.println(m+" "+rg);




    }

    private static void BFS(int r, int c, char[][] map, boolean[][] visited,int dis) {
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true;
        q.add(new int[]{r,c});
        char target = map[r][c];
        if(dis == 1){
            m++;
        }
        else{
            rg++;
        }

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int cr = tmp[0];
            int cc = tmp[1];

            for(int m=0;m<4;m++){
                int nr = cr+mover[m];
                int nc = cc+movec[m];

                if(nr <0 || nr >= N || nc <0 || nc >= N) continue;
                if(visited[nr][nc] || map[nr][nc] != target) continue;

                visited[nr][nc] = true;
                q.add(new int[]{nr,nc});
            }


        }


    }
}