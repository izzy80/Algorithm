import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
0 : 1, 0
1 : 0, -1
2 : -1, 0
3 : 0, 1

출력 : 1*1 정사각형의 꼭짓점이 모두 드래곤 커브의 일부인 것의 개수
 */

public class Main {
    static boolean[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};

    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //완탐할 때 범위 따로 설정 안 해줄려고 일부러 N+1로 잡음
        map = new boolean[101][101];
        StringTokenizer st;
        int x,y,d,g;
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()); //커브의 시작점
            y = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken()); //시작 방향
            g = Integer.parseInt(st.nextToken()); //세대

            dragonCurve(x,y,d,g);
        }

        //1*1 정사각형이 드래곤커브에 속하는지
        //완탐
        for(int i=0; i<100; i++){
            for(int j =0; j < 100; j++){
                if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]){
                    answer++;
                }
            }
        }

        //출력
        System.out.println(answer);
    }

    private static void dragonCurve(int x, int y, int d, int g) {
        //드래곤 커브 수행하는 함수
        //input값 하나당 수행
        List<Integer> d_list = new ArrayList<>();
        d_list.add(d); //1. 방향 추가

        // 2. d_list에 있는 방향들을 마지막부터 뽑으면서 반시계 방향으로 한번 돌린 것을 다시 d_list에 추가한다.
        for(int i=1; i<=g; i++){// 입력 받은 세대(g)만큼 반복하며 방향 넣음
            // 리스트의 마지막 값을 통해 90도 시계방향으로 회전한 방향 값을 리스트에 넣어줌
            for(int j = d_list.size() - 1; j >= 0; j--){
                d_list.add((d_list.get(j)+1)%4);
            }
        }

        //3. d_list에 있는 방향들을 따라서 map[y][x]를 true로 설정한다.
        map[y][x] = true; //처음 시작점 

        for(Integer direction : d_list){
            x += dx[direction];
            y += dy[direction];
            map[y][x] = true;
        }

    }
}