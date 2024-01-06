import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<String> q = new LinkedList<>();

        String num = "";
        for(int i=0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();

            if(S.equals("push")){
                String str = st.nextToken();
                q.add(str);
                num = str;
            }
            else if(S.equals("pop")){
                if(q.isEmpty()){
                    System.out.println("-1");
                }
                else{
                    System.out.println(q.remove());
                }
            }
            else if(S.equals("size")){
                System.out.println(q.size());
            }
            else if(S.equals("empty")){
                if(q.isEmpty()){
                    System.out.println("1");
                }
                else{
                    System.out.println("0");
                }
            }
            else if(S.equals("front")){
                if(q.isEmpty()){
                    System.out.println("-1");
                }
                else{
                    System.out.println(q.peek());
                }
            }
            else {
                if(q.isEmpty()){
                    System.out.println("-1");
                }
                else{
                    System.out.println(num);
                }
            }


        }



    }
}