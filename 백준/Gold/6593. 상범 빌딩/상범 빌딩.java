import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point{
        int l;
        int r;
        int c;

        public Point(int l, int r, int c){
            this.l = l;
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "l=" + l +
                    ", r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
    static ArrayList<Point> points;
    static int L,R,C; //층, 행, 열
    static char[][][] building;
    static int[][][] visited;
    static int[] movel = {0,0,0,0,1,-1};
    static int[] mover = {0,0,1,-1,0,0};
    static int[] movec = {1,-1,0,0,0,0};
    static int distance;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L == 0 && R ==0 && C == 0) break;

            building = new char[L][R][C];
            visited = new int[L][R][C];
            points = new ArrayList<>();
            for(int i=0; i < L; i++){
                for(int j=0; j < R; j++){
                    String tmp = br.readLine();
                    for(int k = 0; k < C; k++){
                        char c = tmp.charAt(k);
                        if(c == 'S' || c == 'E') {
                            points.add(new Point(i, j, k));
                        }
                        building[i][j][k] = c;
                    }
                }
                br.readLine();
            }

//            System.out.println(Arrays.deepToString(building));

            distance = -1;
            BFS(points.get(0));



            //결과 출력
            if(distance != -1){//탈출
                System.out.println("Escaped in "+distance+" minute(s).");
            }
            else{//탈출 못 함
                System.out.println("Trapped!");
            }
        } //tc

    }

    private static void BFS(Point point) {
        Queue<Point> q = new LinkedList<>();
        q.add(point);
        int el = points.get(1).l;
        int er = points.get(1).r;
        int ec = points.get(1).c;

        while(!q.isEmpty()){
            Point cur = q.poll();
//            System.out.println(cur.toString());
            int l = cur.l;
            int r = cur.r;
            int c = cur.c;


            if(l == el && r == er && c == ec){
                distance = visited[el][er][ec];
                return;
            }

            for(int m = 0; m < 6; m++){
                int nl = l + movel[m];
                int nr = r + mover[m];
                int nc = c + movec[m];

                if(nl <0 || nl >= L || nr < 0|| nr >= R || nc < 0|| nc >= C) continue;
                if(visited[nl][nr][nc] > 0 || building[nl][nr][nc] == '#') continue;
                q.add(new Point(nl,nr,nc));
                visited[nl][nr][nc] = visited[l][r][c] +1;
            }

        }

    }
}