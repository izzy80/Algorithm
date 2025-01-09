import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] tomato;
    static int[] mover = {0,0,1,-1};
    static int[] movec = {1,-1,0,0};
    static int[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomato = new int[N][M];
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < M; j++){
                tomato[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new int[N][M];
        for(int i=0; i < N; i++){
            for(int j=0; j < M; j++){
                if(tomato[i][j] == 1){
                    q.add(new int[]{i,j});
                    visited[i][j] = 1;
                }
                if(tomato[i][j] == -1){
                    visited[i][j] = -1;
                }
            }
        }



        BFS();

//        System.out.println(Arrays.deepToString(visited));

        // check
        int ans = 0;

        outer : for(int i=0; i < N; i++){
            for(int j=0; j < M; j++){
                if(visited[i][j] == 0){
                    ans = -1;
                    break outer;
                }
                else{
                    ans = Math.max(ans, visited[i][j]);
                }

            }
        }


        //출력
        System.out.println(ans==-1?ans:ans-1);
    }

    public static void BFS(){

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int m=0; m<4; m++){
                int nr = tmp[0]+mover[m];
                int nc = tmp[1]+movec[m];

                if(nr <0 || nr >= N || nc < 0 || nc >= M) continue;
                if(visited[nr][nc] != 0) continue;
                if(tomato[nr][nc] == 0){
                    q.add(new int[]{nr,nc});
                    visited[nr][nc] = visited[tmp[0]][tmp[1]]+1;
                }
            }
        }
    }
}