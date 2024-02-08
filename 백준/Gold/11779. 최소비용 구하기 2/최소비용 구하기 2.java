import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N,M;
    static ArrayList<Node>[] arrayLists;
    static int start, end;
    static int INF = Integer.MAX_VALUE;
    static int[] cost;
    static int[] route;

    static class Node implements Comparable<Node>{
        int dot;
        int cost;

        public Node(int dot, int cost) {
            this.dot = dot;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //도시의 개수, 정점의 개수
        M = Integer.parseInt(br.readLine()); //버스의 개수 , 간선의 개수
        arrayLists = new ArrayList[N+1];
        cost = new int[N+1];
        route = new int[N + 1];

        Arrays.fill(cost,INF);

        for(int i=0; i< N+1; i++){
            arrayLists[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arrayLists[a].add(new Node(b, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        //다익스트라
        dijkstra(start);

        //최소비용
        System.out.println(cost[end]);

        //경로 추적
        ArrayList<Integer> routes = new ArrayList<>();
        int current = end;
        while(current != 0) {
            routes.add(current);
            current = route[current];
        }
        //도시의 개수
        System.out.println(routes.size());
        for(int i = routes.size() - 1; i >= 0; i--) {
            System.out.print(routes.get(i) + " ");
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];

        q.add(new Node(start, 0));
        cost[start] = 0;
        route[start] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (visited[cur.dot]) continue;
            visited[cur.dot] = true;

            if(cur.dot == end){
                return;
            }

            for(int i=0; i< arrayLists[cur.dot].size() ; i++){
                Node next = arrayLists[cur.dot].get(i); // 다음 지도

                if(cost[next.dot] > cost[cur.dot]+next.cost){
                    cost[next.dot] =  cost[cur.dot]+next.cost; //갱신
                    q.add(new Node(next.dot,cost[next.dot]));
                    route[next.dot] = cur.dot; //다음 인덱스에 현재 dot이 들어가 있음
                }

            }

        }

    }

}