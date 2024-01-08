import java.util.ArrayList;
import java.util.Collections;

class Solution {
         static int[][] answer;
        static int idx;
        public int[][] solution(int[][] nodeinfo) {
            //답
            answer = new int[2][nodeinfo.length];
            
            ArrayList<Node> list = new ArrayList<>();
            for(int i=0; i< nodeinfo.length; i++){
                //list에 nodeinfo를 이용하여 데이터를 집어넣음
                list.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1], null, null));
            }
            //정렬
            Collections.sort(list);

            //list의 첫 번째가 최상위노드가 된다. 
            Node root = list.get(0);
            
            //비교해가며 노드를 삽입하면서 트리를 구현한다.  
            for(int i=1; i< list.size(); i++){
                insertNode(root, list.get(i));
            }

            idx = 0;
            //전위 순회
            Preorder(root);
            
            idx =0;
            //후위 순회
            Postorder(root);

            return answer;
        }

        static void Postorder(Node root) {
            if(root != null){
                Postorder(root.left);
                Postorder(root.right);
                answer[1][idx++] = root.num;
            };
        }

        static void Preorder(Node root) {
            if(root != null){
                answer[0][idx++] = root.num;
                Preorder(root.left);
                Preorder(root.right);
            }
        }

        static void insertNode(Node parent, Node child){
            //x 좌표가 작은 경우에는 왼쪽 자식으로, x 좌표가 큰 경우에는 오른쪽 자식
            if(parent.x > child.x){
                if(parent.left ==  null) parent.left = child;
                else insertNode(parent.left, child);
            }
            else{
                if(parent.right == null) parent.right = child;
                else insertNode(parent.right, child);
            }
        }
        static class Node implements Comparable<Node>{
            //이진 트리 구현하기 위한 노드 
            int num;
            int x;
            int y;

            Node left;
            Node right;

            Node(int num, int x, int y, Node left, Node right){
                this.num = num;
                this.x = x;
                this.y = y;
                this.left = left; //왼쪽 자식 노드
                this.right = right; //오른쪽 자식 노드
            }
            @Override
            public int compareTo(Node o) {
                if(this.y == o.y){
                    //만약 y좌표가 같다면 x좌표가 작은 순서대로
                    return this.x - o.x;
                }
                return o.y - this.y; //y좌표가 큰 순서대로
            }
        }
}