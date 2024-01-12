import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc =0; tc < T ; tc++){
            String str = br.readLine();
            Stack<Character> st = new Stack<>();

            for(int i=0; i< str.length(); i++){
                if(st.isEmpty()){//비어있다면 집어넣어주기
                    st.push(str.charAt(i));
                }
                else {//비어있지 않다면
                    if(str.charAt(i) == ')'){//만약 )가 들어올 때
                        if(st.peek() == '('){
                            st.pop();
                        }
                    }
                    else{//만약 (가 들어올 때
                        st.add(str.charAt(i));
                    }
                }
            }

            if(st.isEmpty()){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }


        }
    }
}