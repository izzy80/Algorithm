import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};

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

        //solve
        HashMap<Integer, Integer> hm = new HashMap<>(); //시간, 조각
        int time = 0;
        while(true){
            //1. 조각 세기
            int cnt = 0;
            for(int i=0; i < N; i++){
                for(int j=0; j < M; j++){
                    if(map[i][j] == 1){
                        cnt++;
                    }
                }
            }
            //2. 치즈 없으면 종료
            if(cnt == 0 ) {
                break;
            }else{
                hm.put(time, cnt);
            }
            //3. 치즈 녹이기
            visited = new boolean[N][M];
            BFS(0,0);
            cheese();
            //4. 시간 증가
            time++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(time).append("\n");
        sb.append(hm.get(time-1));
        System.out.println(sb.toString());

    }

    private static void cheese() { //치즈 녹이기
        for(int i=0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 2){
                    map[i][j] = 0;
                }
            }
        }
    }


    private static void  BFS(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c] =true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int m = 0; m < 4; m++){
                int nr = tmp[0]+mover[m];
                int nc = tmp[1]+movec[m];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 1) {
                    map[nr][nc] = 2;
                    visited[nr][nc] = true;
                }
                if(map[nr][nc] == 0){
                    q.add(new int[]{nr,nc});
                    visited[nr][nc] = true;
                }
            }

        }

    }
}