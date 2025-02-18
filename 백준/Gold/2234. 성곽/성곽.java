import java.util.*;
import java.io.*;

/**
 * 다음을 구하기
 * 1. 이 성에 있는 방의 개수
 * 2. 가장 넓은 방의 넓이
 * 3. 하나의 벽을 제거해서 얻을 수 있는 가장 넓은 방의 크기
 *
 */
public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[][][] wall;
    static ArrayList<Integer> room_list;
    static int[] mover = {0,-1,0,1}; //서북동남
    static int[] movec = {-1,0,1,0};

    static int[] movedir = {1,2,4,8}; //서북동남

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i= 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //solve
        wall = new int[N][M][2];
        visited = new boolean[N][M];
        room_list = new ArrayList<>();
        int room_cnt = 0;
        for(int i=0; i < N; i++){
            for(int j=0; j < M; j++){
                if(!visited[i][j]){
                    bfs(i,j,room_cnt);
                    room_cnt++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        //1. 성에 있는 방의 개수
        sb.append(room_cnt).append("\n");
        //2. 가장 넓은 방의 넓이
        Collections.sort(room_list, Collections.reverseOrder());
        sb.append(room_list.get(0)).append("\n");
        //3. 벽 한 칸 부시고 가장 큰 넓이
        sb.append(max_room());

        //print
        System.out.println(sb.toString());
    }

    public static int max_room(){
        int max_size = 0;
        for(int i=0; i < N; i++){
            for(int j=0; j < M; j++){
                for(int m=0; m < 4; m++){
                    int nr = i + mover[m];
                    int nc = j + movec[m];

                    if(nr <0 || nr >= N || nc <0 || nc>=M) continue;
                    if(wall[i][j][0] != wall[nr][nc][0]){
                        //방번호(idx)가 다르면
                        max_size = Math.max(max_size, wall[i][j][1]+wall[nr][nc][1]);
                    }
                }
            }
        }

        return max_size;
    }

    public static void bfs(int r, int c, int idx){
        int room_area = 0;
        Queue<int[]> q = new ArrayDeque<>();
        ArrayList<int[]> one = new ArrayList<>();

        q.add(new int[]{r,c});
        one.add(new int[]{r,c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int cr = tmp[0];
            int cc = tmp[1];
            room_area++;

            int wall = map[cr][cc]; //현재 내 위치에서 벽 위치

            for(int m=0; m < 4; m++){
                if((movedir[m]&wall) != 0) continue;   //막힘 -> 못지나감
                int nr = cr + mover[m];
                int nc = cc + movec[m];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(visited[nr][nc]) continue;
                q.add(new int[]{nr,nc});
                one.add(new int[]{nr,nc});
                visited[nr][nc] = true;
            }
        }
        for(int[] a : one){
            wall[a[0]][a[1]][0] = idx;
            wall[a[0]][a[1]][1] = room_area;
        }
        room_list.add(room_area);
    }
}