import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for(int i=0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            
            if(num > start){
                for(int j= start+1; j <= num; j++){
                    st.push(j);
                    sb.append("+").append("\n");
                }
                start = num; 
            }
            else{
                if(st.peek() != num){
                    System.out.println("NO");
                    return; 
                }
            }
            st.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb.toString());

    }
}