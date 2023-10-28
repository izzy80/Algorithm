import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Stack<Integer> st = new Stack<>();
        for(int i=0; i<N;i++){
            String str = br.readLine();
//            System.out.println(str);
            String[] starr = str.split(" ");

            if(starr.length ==2){
                //push일 때만
                int num = Integer.parseInt(starr[1]);
                st.push(num);
            }
            else{
                if(starr[0].equals("pop")){
                    if(st.isEmpty()){
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(st.pop());
                    }
                }
                else if(starr[0].equals("size")){
                    System.out.println(st.size());
                }
                else if(starr[0].equals("empty")){
                    if(st.isEmpty()){
                        System.out.println(1);
                    }
                    else {
                        System.out.println(0);
                    }
                }
                else{//top일 때
                    if(st.isEmpty()){
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(st.peek());
                    }
                }
            }

        }
    }
}