import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int i=0; i < N; i++){
            String str = br.readLine();

            Stack<Character> st = new Stack<>();

            for(int j =0; j < str.length(); j++){
                char c = str.charAt(j);
                if(st.isEmpty()){
                    st.add(c);
                }
                else{
                    if(c == 'A'){
                        if(st.peek() == 'A'){
                            st.pop();
                        }
                        else{
                            st.add(c);
                        }
                    }
                    else{//B
                        if(st.peek() == 'B'){
                            st.pop();
                        }
                        else{
                            st.add(c);
                        }
                    }
                }
            }

            if(st.isEmpty()){
                answer++;
            }
        }

        System.out.println(answer);

    }
}