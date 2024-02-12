import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
t : 테스트 케이스
n : 맥주를 파는 편의점의 개수
n+2 : 상근이네 집, 편의점, 펜타포트 락 페스티벌 좌표
페스티벌 : happy
맥주 바닥 : sad
 */
public class Main {
    static ArrayList<Point> list;
    static ArrayList<Integer>[] graph;
    static String answer;
    static boolean[] visited;
    static class Point {
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //TC
        for(int tc = 0; tc < T; tc ++){
            StringTokenizer st;
            int N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();

            for(int i=0; i <N+2; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.add(new Point(x,y));
            }

            //graph 만들기
            graph = new ArrayList[list.size()]; //list.size가 정점의 개수
            for(int i=0; i < list.size(); i++){
                graph[i] = new ArrayList<>();
            }

            for(int i=0; i < list.size(); i++){
                for(int j=i+1; j < list.size(); j++){
                    Point A = list.get(i);
                    Point B = list.get(j);
                    if(Math.abs(A.x - B.x)+Math.abs(A.y - B.y) > 1000) continue;
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }

            answer = "sad";
            visited = new boolean[N + 2];
            BFS(0);

            System.out.println(answer);

        }//tc


    }

    private static void BFS(int idx) {
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        visited[idx] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if(cur == list.size()-1){
                answer = "happy";
                return;
            }

            for(int i=0; i < graph[cur].size(); i++){
                int next = graph[cur].get(i);

                if(!visited[next]){
                    q.add(next);
                    visited[next] = true;
                }
            }

        }

    }
}