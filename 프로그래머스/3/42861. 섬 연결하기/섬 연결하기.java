
import java.util.Arrays;
import java.util.Comparator;
class Solution {
    
static int[] parent;
        public int solution(int n, int[][] costs) {
            int answer = 0;
            //크루스칼 알고리즘을 사용하기 위해서 가중치 기준 오름차순 정렬
            Arrays.sort(costs, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2]- o2[2];
                }
            });

            //Uion find를 사용하기 위해 parent 배열 선언-> 한 그래프에 있는지 파악하기 위해 -> 사이클이 도는지 확인하기 위해
            parent = new int[n];
            for(int i=0; i < n; i++){
                parent[i] = i; //default를 자기자신으로 초기화
            }

            for(int[] edge : costs){
                int from = edge[0];
                int to = edge[1];
                int cost = edge[2];

                //이 둘의 부모를 UnionFind를 이용해서 찾음
                int fromParent = findParent(from);
                int toParent = findParent(to);

                if(fromParent == toParent) continue; //부모가 같다면 두 노드가 같은 그래프 안에 있다는 소리이다.
                //따라서 해당 간선을 선택하지 않는다.

                answer += cost;
                parent[toParent] = fromParent; //간선을 연결해 두 노드가 같은 그래프에 속하게 되었으므로 부모 노드를 갱신한다.

            }
            return answer;
        }

        private int findParent(int node) {
            //부모노드가 자기자신과 같은 노드를 찾을 때까지 재귀호출
            if(parent[node] == node) return node;
            return parent[node] = findParent(parent[node]);

        }
}