import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M,N,K;
    static int[][] map;
    static boolean[][] visited;
    static int cnt;

    static int[] mover = new int[]{-1,0,1,0};
    static int[] movec = new int[]{0,1,0,-1};

    static List list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); //5
        N = Integer.parseInt(st.nextToken()); //7
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for(int i =0; i< K ;i++){
            st = new StringTokenizer(br.readLine());
            int lx =  Integer.parseInt(st.nextToken()); //왼쪽 아래
            int ly =  Integer.parseInt(st.nextToken()); //왼쪽 아래
            int rx =  Integer.parseInt(st.nextToken()); //오른쪽 위
            int ry =  Integer.parseInt(st.nextToken()); //오른쪽 위

            for(int r=M-ry;r<M-ly;r++){
                for(int c=lx;c<rx;c++){
//                    System.out.println(r+","+c);
                    map[r][c] = 1;
                }
            }
        }//for문
        cnt =0;
        list = new LinkedList();

        for(int i=0; i< M;i++){
            for(int j=0; j< N; j++){
                if(!visited[i][j] && map[i][j] == 0){
                    BFS(i,j);
                }
            }
        }

        System.out.println(cnt);
        list.sort(Comparator.naturalOrder());
        for(int i=0; i< list.size();i++){
            System.out.print(list.get(i) +" ");
        }
        System.out.println();
    }

    private static void BFS(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true;
        q.add(new int[]{r,c});
        cnt++;

        int area =0;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int cr = tmp[0];
            int cc = tmp[1];
            area++;

            for(int m =0; m<4;m++){
                int nr = cr+mover[m];
                int nc = cc+movec[m];

                if(nr <0 || nr >= M || nc <0|| nc >= N) continue;
                if(visited[nr][nc] || map[nr][nc] == 1) continue;

                visited[nr][nc] = true;
                q.add(new int[]{nr,nc});
            }


        }
        list.add(area);
    }
}