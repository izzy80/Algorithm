import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i <= N; i++){
            q.add(i);
        }

        while(q.size() > 1){
            //첫 번째거 지워준다.
            q.poll();

            //두 번째거 제일 아래로 옮긴다.
            q.add(q.poll());
        }

        System.out.println(q.peek());


    }
}