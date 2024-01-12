import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Deque<String> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            String s;

            if(str.equals("push_front")){
                s = st.nextToken();
                dq.addFirst(s);
            }
            else if(str.equals("push_back")){
                s = st.nextToken();
                dq.addLast(s);
            }
            else if(str.equals("pop_front")){
               if(dq.isEmpty()){//비어있다면
                   sb.append("-1").append("\n");
               }
               else{
                   sb.append(dq.pollFirst()).append("\n");
               }

            }
            else if(str.equals("pop_back")){
                if(dq.isEmpty()){//비어있다면
                    sb.append("-1").append("\n");
                }
                else{
                    sb.append(dq.pollLast()).append("\n");
                }
            }
            else if(str.equals("size")){
                sb.append(dq.size()).append("\n");
            }
            else if(str.equals("empty")){
                if(dq.isEmpty()){//비어있다면
                    sb.append("1").append("\n");
                }
                else{
                    sb.append("0").append("\n");
                }
            }
            else if(str.equals("front")){
                if(dq.isEmpty()){//비어있다면
                    sb.append("-1").append("\n");
                }
                else{
                    sb.append(dq.peekFirst()).append("\n");
                }
            }
            else{//back
                if(dq.isEmpty()){//비어있다면
                    sb.append("-1").append("\n");
                }
                else{
                    sb.append(dq.peekLast()).append("\n");
                }
            }
        }

        System.out.println(sb.toString());
    }
}