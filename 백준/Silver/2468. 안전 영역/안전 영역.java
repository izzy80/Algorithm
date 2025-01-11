import java.util.*;
import java.io.*;

//물에 잠기지 않는 안전한 영역의 최대 개수
public class Main {
    static int N;
    static int[][] map;
    static int answer = Integer.MIN_VALUE;
    static int[] mover = {1,-1,0,0};
    static int[] movec = {0,0,1,-1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //행과 열의 개수
        map = new int[N][N];

        StringTokenizer st;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < N; j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;

                min = Math.min(num,min);
                max = Math.max(num,max);
            }
        }

//        System.out.println(min); //2
//        System.out.println(max); //9

        //solve
        for(int i=min; i <= max; i++){
            int cnt = 0;
            visited = new boolean[N][N];
            for(int j =0; j < N; j++){
                for(int k = 0; k<N; k++){
                    if(map[j][k] > i && !visited[j][k]){
                        bfs(j,k,i);
                        cnt++;
                    }
                }
            }
//            System.out.println(Arrays.deepToString(visited));
//            System.out.println("cnt = "+ cnt +" , i = "+i);

            answer = Math.max(cnt, answer);
        }

        //print
        System.out.println(answer == 0? 1:answer);
    }

    public static void bfs(int r, int c, int level){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int cr = tmp[0];
            int cc = tmp[1];

            for(int m=0; m < 4; m++){
                int nr = cr + mover[m];
                int nc = cc + movec[m];

                if(nr <0 || nr >= N || nc < 0 || nc >= N) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] > level) {
                    q.add(new int[]{nr,nc});
                    visited[nr][nc] = true;
                }
            }
        }

    }
}