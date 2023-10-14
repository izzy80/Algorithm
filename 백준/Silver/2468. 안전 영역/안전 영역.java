import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[][] onemap;
    static boolean[][] visited;

    static int min;
    static int max;
    static int area;

    static int[] mover = new int[]{-1,0,1,0};
    static int[] movec = new int[]{0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for(int i=0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                min = Integer.min(min, num);
                max = Integer.max(max, num);
            }
        }

//        System.out.println(min);
//        System.out.println(max);

        int ans =Integer.MIN_VALUE;
        for(int t= min; t<=max; t++){
            onemap = new int[N][N];
            visited = new boolean[N][N];
            area =0;

            for(int i=0; i< N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j]<=t){
                        onemap[i][j] = 1;
                    }
                }
            }
            //onemap을 1로 한다.
//            System.out.println(Arrays.deepToString(onemap));
            for(int i=0; i< N;i++){
                for(int j=0;j<N;j++){
                    if(onemap[i][j]==0 && !visited[i][j]){
                        BFS(i,j);
                    }
                }
            }
//            System.out.println(area);
            ans = Integer.max(area,ans);

        }//tc
        if(ans == 0){
            System.out.println(1);
        }
        else{
            System.out.println(ans);
        }




//        System.out.println(Arrays.deepToString(map));
    }

    private static void BFS(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c] = true;
        area++;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int cr = tmp[0];
            int cc = tmp[1];

            for(int m=0;m<4;m++){
                int nr = cr+mover[m];
                int nc = cc+movec[m];

                if(nr <0 || nr >= N || nc <0|| nc >= N) continue;
                if(visited[nr][nc] || onemap[nr][nc] == 1) continue;

                visited[nr][nc] = true;
                q.add(new int[]{nr,nc});

            }


        }

    }
}