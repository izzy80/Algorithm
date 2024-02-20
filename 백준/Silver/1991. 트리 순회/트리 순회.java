import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node{ //Node 생성
        char data;
        Node left;
        Node right;

        public Node(char data){
            this.data = data;
        }
    }

    static class Tree{//tree 생성
        Node root;

        //메소드
        public void createNode(char data, char leftData, char rightData){

            if(root == null){//root가 비어있다면
                //완전 상위 노드 생성. 처음 1번만
                root = new Node(data);
                root.left = leftData=='.'? null : new Node(leftData);
                root.right = rightData=='.'? null : new Node(rightData);
            }
            else{
                //root가 null이 아니라면 탐색 시작
                searchNode(root, data, leftData, rightData);
            }
        }

        private void searchNode(Node node, char data, char leftData, char rightData) {
            if(node == null){
                //노드가 없을 경우 return
                return;
            }
            else if(node.data==data){
                //노드를 찾은 경우
                node.left = leftData == '.'?null:new Node(leftData);
                node.right = rightData == '.'?null:new Node(rightData);
            }
            else{
                searchNode(node.left, data, leftData, rightData); //오른쪽 재귀 탐색
                searchNode(node.right, data, leftData, rightData); //왼쪽 재귀 탐색
            }
        }

        //전위 순회 : Root -> Left -> Right
        public void preOrder(Node node){
            if(node != null){
                System.out.print(node.data); //root 출력
                if(node.left!=null) preOrder(node.left); //left를 중심으로 다시 preOrder
                if(node.right != null) preOrder(node.right);
            }
        }

        //중위순회 : Left -> Root -> Right
        public void inOrder(Node node){
            if(node != null){
                if(node.left!=null) inOrder(node.left); //left를 중심으로 다시 preOrder
                System.out.print(node.data); //root 출력
                if(node.right != null) inOrder(node.right);
            }
        }

        //후위순회 : Left -> Right -> Root
        public void postOrder(Node node){
            if(node != null){
                if(node.left!=null) postOrder(node.left); //left를 중심으로 다시 preOrder
                if(node.right != null) postOrder(node.right);
                System.out.print(node.data); //root 출력
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //이진 트리의 노드의 개수
        StringTokenizer st;

        Tree tree = new Tree();
        for(int i=0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.createNode(root, left, right);
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
    }
}