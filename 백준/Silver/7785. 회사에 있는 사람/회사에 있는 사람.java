import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String inout = st.nextToken();

            if(hm.get(name) == null && inout.equals("enter") ||
                    hm.get(name) == 0 && inout.equals("enter")) hm.put(name, 1);
            if(hm.get(name) != 0 && inout.equals("leave")) hm.put(name, 0);
        }

        ArrayList<String> list = new ArrayList<>();
        for(String s : hm.keySet()){
            if(hm.get(s) == 1){
                list.add(s);
            }
        }

        Collections.sort(list, Collections.reverseOrder());

        for(String s : list){
            System.out.println(s);
        }
    }
}