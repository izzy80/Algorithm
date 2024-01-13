import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<= K; i++){
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(q.size() > 1){
            for(int i=0; i< N-1; i++){
                int value = q.poll();
                q.offer(value);
            }
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll()).append(">");
        System.out.println(sb.toString());



    }
}