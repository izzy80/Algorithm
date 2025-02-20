import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static class Node{
        String value;
        Node left;
        Node right;

        public Node(String value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    static Node tree = new Node("A",null, null); //트리 root 만들기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            String root = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            insertNode(tree, root, left, right);
        }

        preOrder(tree);
        sb.append("\n");
        inOrder(tree);
        sb.append("\n");
        postOrder(tree);

        System.out.println(sb.toString());
    }

    public static void preOrder(Node node){
        if(node == null){
            return;
        }
        sb.append(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        sb.append(node.value);
        inOrder(node.right);
    }

    public static void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value);
    }

    public static void insertNode(Node temp, String root, String left, String right){
        if(temp.value.equals(root)){
            //현재 tree의 value가 root랑 같다면?
            //양 옆에 값을 넣을 수 있음

            //left가 .이면 null, 아니면 새로운 node 추가
            temp.left = (left.equals(".")? null : new Node(left, null, null));
            temp.right = (right.equals(".")? null : new Node(right, null, null));
        }
        else{
            //현재 tree의 value가 root와 같지 않다면
            //탐색을 해야함.
            //그래서 left에 값이 있다면 거기를 탐색
            if(temp.left != null){
                insertNode(temp.left, root, left, right);
            }
            if(temp.right != null){
                insertNode(temp.right, root, left, right);
            }
        }
    }
}