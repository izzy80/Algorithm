import java.util.*;
import java.io.*;

public class Main {
    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); //5
        N = Integer.parseInt(st.nextToken()); //7
        map = new int[M][N];

        K = Integer.parseInt(st.nextToken());
        for(int i=0; i <K; i++){
            //왼쪽아래 x,y
            //오른쪽 위 x,y
            st = new StringTokenizer(br.readLine());
            int left_x = Integer.parseInt(st.nextToken());
            int left_y = Integer.parseInt(st.nextToken());
            int right_x = Integer.parseInt(st.nextToken());
            int right_y = Integer.parseInt(st.nextToken());

            for(int j=M-right_y; j < M-left_y; j++){
                for(int k = left_x; k <right_x ; k++){
                    map[j][k] = 1;  //칠해진 곳
                }
            }
        }

        //solve 분리된 영역, 넓이가 얼마? 넓이 순으로 오름차순
        int cnt = 0;
        ArrayList<Integer> size = new ArrayList<>();
        visited = new boolean[M][N];
        for(int i=0; i < M; i++){
            for(int j=0; j < N; j++){
                if(map[i][j] == 0 && !visited[i][j]){
                    int new_size = bfs(i,j);
                    cnt++;
                    size.add(new_size);
                }
            }
        }

        //오름차순으로 정렬
        Collections.sort(size);

        //print
        System.out.println(cnt);
        StringBuilder sb = new StringBuilder();
        for(int value : size){
            sb.append(value).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static int bfs(int r, int c){
        int ss = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int cr = tmp[0];
            int cc = tmp[1];

            for(int m=0; m <4; m++){
                int nr = cr+mover[m];
                int nc = cc+movec[m];

                if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 1) continue;
                q.add(new int[]{nr,nc});
                visited[nr][nc] = true;
                ss++;
            }
        }

        return ss; //사이즈 리턴
    }
}