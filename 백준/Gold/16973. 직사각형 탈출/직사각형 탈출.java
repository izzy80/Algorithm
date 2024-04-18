import java.util.*;
import java.io.*;
/*
0은 빈칸
1  은 벽
 */

public class Main {
    static int N,M;
    static int[][] map;
    static int H,W;
    static int sr,sc,fr,fc;

    static int ans;
    static class Point{
        int rb;
        int cb;
        int cnt;

        public Point(int rb, int cb, int cnt) {
            this.rb = rb;
            this.cb = cb;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        sr = Integer.parseInt(st.nextToken())-1;
        sc = Integer.parseInt(st.nextToken())-1;
        fr = Integer.parseInt(st.nextToken())-1;
        fc = Integer.parseInt(st.nextToken())-1;

        //solve
        ans = -1;
         BFS();
         System.out.println(ans == -1? -1 : ans);
    }

    static public void BFS(){
        int[] mover  = {0,0,-1,1};
        int[] movec  = {-1,1,0,0};
        boolean[][] visited = new boolean[N][M];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(sr, sc, 0));
        visited[sr][sc] = true;

        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.rb == fr && p.cb == fc){
                ans = p.cnt;
                break;
            }

            for(int m = 0; m < 4; m++){
                int nsr = p.rb+mover[m];
                int nsc = p.cb+movec[m];

                if(nsr < 0 || nsr -1 + H >= N || nsc < 0 || nsc - 1 + W >= M) continue;
                if(checkWall(nsr,nsc,m)) continue;//true면 1에 걸렸다는 것
                if(visited[nsr][nsc]) continue;
                //System.out.println(Arrays.deepToString(visited));
                q.add(new Point(nsr, nsc, p.cnt+1));
                visited[nsr][nsc] = true;
            }

        }
    }

    private static boolean checkWall(int nsr, int nsc, int dir) {
        switch(dir){
            case 0:
                for(int i=nsr; i <=nsr-1+H ;i++){
                    if(map[i][nsc] == 1) {
                        return true;
                    }
                }
                break;
            case 1:
                for(int i=nsr; i <=nsr-1+H ;i++){
                    if(map[i][nsc-1+W] == 1) {
                        return true;
                    }
                }
                break;
            case 2:
                for(int i=nsc; i <=nsc-1+W ;i++){
                    if(map[nsr][i] == 1) {
                        return true;
                    }
                }
                break;
            case 3:
                for(int i=nsc; i <=nsc-1+W ;i++){
                    if(map[nsr-1+H][i] == 1) {
                        return true;
                    }
                }
                break;
        }
        return false;
    }
}