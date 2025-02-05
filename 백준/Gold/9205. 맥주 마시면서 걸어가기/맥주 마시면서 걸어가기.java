import java.util.*;
import java.io.*;

/**
 * 송도(상근이네 집) -> 펜타포트 락 페스티벌
 * 맥주 한 박스(20개) 들고 출발
 * 50m에 한 병씩 마신다. 50m 가려면 직전에 한 병 마심
 * 편의점에서 빈 병은 버리고 새 맥주 병 살 수 있음. 단 상자의 맥주는 20병을 넘을 수 없음
 *
 * 행복하게 페스티벌에 갈 수 있다면 "happy"
 * 중간에 맥주가 바닥나면 "sad"
 */

/**
 * 그냥 정점, 간선이 있는 그래프 형태라고 생각하기
 */
public class Main {
    static int convenience_cnt;
    static Point[] places;
    static String answer;
    static int MIN_DISTANCE =  -32768;
    static int MAX_DISTANCE =  32768;
    static boolean[] visited;

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc = 0; tc < T ; tc++){
            answer = "sad";
            //input값 입력
            convenience_cnt = Integer.parseInt(br.readLine());
            places = new Point[convenience_cnt+2];

            for(int i=0; i < convenience_cnt+2; i++){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                places[i] = new Point(r,c);
            }
            //solve
            BFS(places[0].r, places[0].c);

            //print
            System.out.println(answer);
        }
    }
    //함수
    public static void BFS(int r, int c){
        visited = new boolean[convenience_cnt+2];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r,c));
        visited[0] = true; //출발지 등록

        while(!q.isEmpty()){
            Point now = q.poll();

            for(int i=1; i < convenience_cnt+2; i++){
              if(visited[i]) continue; //방문했다면
              if(!passable(now, places[i])) continue;//멘하튼 거리 내에 없으면
              if(i == convenience_cnt+1) {
                  answer = "happy";
                  return;
              }
                q.add(new Point(places[i].r,places[i].c));
                visited[i] = true;
            }

        }

    }
    static public boolean passable(Point a, Point b) {
        int distance = Math.abs(a.r - b.r) + Math.abs(a.c - b.c);
        if (distance <= 1000) {
            return true;
        } else {
            return false;
        }
    }
}