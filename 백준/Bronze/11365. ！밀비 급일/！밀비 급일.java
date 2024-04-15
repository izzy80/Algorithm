import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){//계속 돌아
            String str = br.readLine();
            if(str.equals("END")) break; //END면 break

            Stack<Character> st = new Stack<>();
            for(int i=0; i < str.length(); i++){
                st.push(str.charAt(i));
            }

            StringBuilder sb = new StringBuilder();
            while(!st.isEmpty()){
                sb.append(st.pop());
            }

            System.out.println(sb.toString());
        }
    }

}