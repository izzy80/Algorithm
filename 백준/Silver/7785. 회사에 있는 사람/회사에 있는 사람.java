import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        TreeMap<String, String> thm = new TreeMap<>((o1,o2) -> {
            return o2.compareTo(o1);
        });
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String inout = st.nextToken();

            if(inout.equals("enter")){
                thm.put(name, inout);
            }
            else{
                thm.put(name, inout);
            }
        }

        for (String s : thm.keySet()) {
            if(thm.get(s).equals("enter")){
                System.out.println(s);
            }
        }



    }
}