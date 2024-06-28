import java.util.*;
import java.io.*;

/*
map에는 물고기 M마리와 아기 상어 1마리가 있다
물고기는 최대 1마리 존재
아기 상어의 크기 : 2
1초에 상하좌우를 움직임 -> BFS
아기 상어보다
큰 물고기 : 지나갈 수 없음, 못 먹음
같은 크기 물고기 : 지나갈 수 있음, 못 먹음
작은 물고기 : 지나갈 수 있음, 먹음

더 이상 먹을 물고기 없으면 엄마 상어에게 도움 요청
먹을 수 있는 물고기가 1마리면 그 물고기를 먹으러 감
먹을 수 있는 물고기가 1마리 이상이면 가장 가까운 물고기 먹음
- 가장 가까운 물고기가 여러개면 가장 위 -> 가장 왼쪽

물고기 먹는데 현재 내 크기랑 같은 양의 물고기의 양을 먹으면 1 증가

결과값
물고기 잡아먹는 시간

0 : 빈칸
1,2,3,4,5,6 : 물고기 크기
9 : 아기 상어
 */

public class Main {
    static int N;
    static int[][] map;
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};
    static int shark_size = 2;
    static ArrayList<Point> can_eat;

    static class Point {
        int distance;
        int r;
        int c;

        public Point(int distance, int r, int c){//생성자
            this.distance = distance;
            this.r = r;
            this.c = c;
        }

        //정렬
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int fish_cnt = 0;
        int sharkr = 0; //상어의 위치
        int sharkc = 0;
        for(int i=0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j < N; j++){
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num != 0 && num != 9) fish_cnt++;
                if(num == 9){
                    sharkr = i;
                    sharkc = j;
                    map[i][j] = 0; //상어위치 0으로 갱신 -> bfs를 위해서 이거 안 하면 숫자 커서 이동 못 함
                }
            }
        }

        int answer = 0;
        int shark_eat =0;
        if(fish_cnt != 0){ //fish_cnt가 0이 아니면 실행
            while(true){
                //만약에 shark_eat이 상어 크기랑 같으면 상어크기+1
                if(shark_eat == shark_size) {
                    shark_size++;
                    shark_eat = 0; //다시 0으로 갱신
                }

                //1. bfs 탐색해서 먹을 수 있는 물고기 넣기
                BFS(sharkr, sharkc);

                //2. list 정렬
                if(can_eat.size() >= 1){//1보다 크면
                    //1. 정렬해서 맨 앞 거 가져오기
                    Collections.sort(can_eat, (o1, o2) -> {
                        if(o1.distance == o2.distance){ //거리가 같다면
                            if(o1.r == o2.r){ //둘 다 같은 행에 있다면
                                return o1.c - o2.c;
                            }
                            return o1.r - o2.r;
                        }
                        return o1.distance - o2.distance;
                    });

                    int nr = can_eat.get(0).r;
                    int nc = can_eat.get(0).c;

                    //상어 위치 업데이트
                    //상어가 먹은 물고기 업데이트
                    //먹었으면 map 0으로 업데의트
                    sharkr = nr;
                    sharkc = nc;
                    shark_eat++;
                    answer += can_eat.get(0).distance;
                    map[nr][nc] = 0;
                }
                else{//list.size가 0이면
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    static public void BFS(int sharkr, int sharkc){
        can_eat = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sharkr, sharkc});
        int[][] dist = new int[N][N];

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int r = tmp[0];
            int c = tmp[1];

            for(int m=0; m < 4; m++){
                int nr = r + mover[m];
                int nc = c + movec[m];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if(dist[nr][nc] == 0 && map[nr][nc] <= shark_size){
                    dist[nr][nc] = dist[r][c]+1;
                    q.add(new int[]{nr,nc});
                    if (1 <= map[nr][nc] && map[nr][nc] <= 6 && map[nr][nc] < shark_size) {
                        //다음 물고기로 선정되면 can_eat에 넣기
                        can_eat.add(new Point(dist[nr][nc], nr, nc));
                    }
                }
            }
        }
    }
}