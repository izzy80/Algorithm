import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
T : 선생님이 존재하는 칸
S : 학생이 존재하는 칸
O : 장애물이 존재하는 칸
X : 아무것도 존재하지 않는 칸
 */
public class Main {
    static int N;
    static String[][] map;
    static boolean[][] visited;
    static String answer;
    static int[] mover = {-1, 1, 0, 0};
    static int[] movec = {0, 0, -1, 1};
    static class Point{
        int r;
        int c;

        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static List<Point> teachers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = String.valueOf(st.nextToken());
            }
        }

        //solve
        visited = new boolean[N][N];
        teachers = new ArrayList<>();
        for(int i=0; i < N; i++){
            for(int j=0; j< N; j++){
                if(map[i][j].equals("T")){
                    teachers.add(new Point(i, j));
                }
            }
        }

        DFS(0);
        System.out.println("NO");
    }

    private static void DFS(int depth) {
        if(depth == 3){
            if(BFS()){
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }

        for(int i=0; i < N; i++){
            for(int j=0; j < N; j++){
                if(map[i][j].equals("X")){
                    map[i][j] = "O";
                    DFS(depth+1);
                    map[i][j] = "X";
                }
            }
        }
    }

    private static boolean BFS() {
        Queue<int[]> q = new LinkedList<>();

        for (Point teacher : teachers) {
            q.add(new int[]{teacher.r, teacher.c});
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int m =0; m < 4; m++){
                int nr = cur[0];
                int nc = cur[1];

                while(true){
                    //현재 위치를 기준으로 계속 상하좌우를 뻗어나감. 
                    nr += mover[m];
                    nc += movec[m];

                    if(nr <0 || nr >= N || nc < 0|| nc >= N) break;
                    if(map[nr][nc].equals("O")) break;
                    if(map[nr][nc].equals("S")){//학생 만나면 끝
                        return false;
                    }
                }
            }
        }
        return true;


    }
}