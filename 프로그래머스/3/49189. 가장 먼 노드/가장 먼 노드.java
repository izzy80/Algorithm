import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static int max;
    static int N;
    static Integer[] order;
    
    public int solution(int n, int[][] edge) {
           N = n;
            int answer = 0;
            graph = new ArrayList[n+1];
            for(int i=1; i <= n; i++){
                graph[i] = new ArrayList<>();
            }
            for(int i=0; i < edge.length; i++){
                int a = edge[i][0];
                int b = edge[i][1];
//                System.out.println("a = "+a+", b = "+b);
                graph[a].add(b);
                graph[b].add(a);
            }

            //bfs
            max = Integer.MIN_VALUE;
            BFS(1);
            Arrays.sort(order, Collections.reverseOrder());
//            System.out.println(Arrays.toString(order));

            for(int i=0; i < order.length; i++){
                if(order[i] == max){
                    answer++;
                }
                else{
                    break;
                }
            }
            return answer;
        }
        static public void BFS(int idx){
            Queue<Integer> q = new LinkedList<>();
            order = new Integer[N+1];
            Arrays.fill(order, -1);
            q.add(idx);
            order[idx] = 0;

            while(!q.isEmpty()){
                int tmp = q.poll();
                if(max < order[tmp]) max = order[tmp];
                for(int next : graph[tmp]){
                    if(order[next]==-1){

                        order[next] = order[tmp]+1;
                        q.add(next);
                    }
                }
            }
        }
}