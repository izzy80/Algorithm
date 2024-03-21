import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M,N;
    static int[] mover = {1,-1,0,0};
    static int[] movec = {0,0,1,-1};
    static int[][] map;
    static int areaCount = 0;
    static boolean[][] visited;
    static ArrayList<Integer> result = new ArrayList<>();



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); //5
        N = Integer.parseInt(st.nextToken()); //7
        int K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        //map만들기
        for(int i=0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());


            for(int j=y1; j<y2; j++){
                for(int k=x1; k<x2; k++){
                    map[j][k] = 1;
                }
            }
        }
//        System.out.println(Arrays.deepToString(map));

        //BFS
        for(int i=0; i<M; i++){
            for(int j=0; j < N; j++){
                if(map[i][j]==0 && !visited[i][j]){
                    //map이 0이면서 방문하지 않은 곳
                    BFS(i,j);
                    areaCount++; //BFS가 돌아갈 때마다 cnt증가.
                }
            }
        }

        System.out.println(areaCount);
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for (Integer i : result) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void BFS(int i, int j) {
        int area = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true; //방문처리

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int r = tmp[0];
            int c = tmp[1];

            for(int m=0; m <4; m++){
                int nr = r + mover[m];
                int nc = c + movec[m];

                if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
                if(map[nr][nc]==1 || visited[nr][nc]) continue;
                //map=1면 선택X. visited=true면 이미 방문
                q.add(new int[]{nr,nc});
                visited[nr][nc] = true;
                area++;
            }

        }

        result.add(area);

    }
}