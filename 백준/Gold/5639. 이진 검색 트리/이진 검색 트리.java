import java.util.*;
import java.io.*;

public class Main {
    static class Node{
        int value;
        Node left, right;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public void insert(int number){
            if(number < this.value){
                if(this.left == null) this.left = new Node(number);
                else this.left.insert(number);
            }
            else{
                if(this.right == null) this.right = new Node(number);
                else this.right.insert(number);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine())); //루트 노드 입력


        String str;
        while(true){
            str = br.readLine();
            if(str == null || str.isEmpty()){
                break;
            }
            int cur = Integer.parseInt(str);
            root.insert(cur);
        }

        postOrder(root);
    }
    static void postOrder(Node curr){
        if(curr == null) return;

        postOrder(curr.left); //왼쪽 순회
        postOrder(curr.right); //오른쪽 순회
        System.out.println(curr.value);
    }
}