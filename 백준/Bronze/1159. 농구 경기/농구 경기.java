import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<Character, Integer> hm = new HashMap<>();
        ArrayList<Character> list = new ArrayList<>(); 
        
        for(int i=0; i < N; i++){
            char str = br.readLine().charAt(0);

            int cnt =  hm.getOrDefault(str, 0)+1;
            hm.put(str, cnt);

            if(cnt == 5) list.add(str);
        }

//        for(char s : hm.keySet()){
//            System.out.println(s + " : "+ hm.get(s));
//        }

        if(list.size() == 0){
            System.out.println("PREDAJA");
        }
        else{
            StringBuilder sb = new StringBuilder(); 
            Collections.sort(list);
            
            for(char c : list){
                sb.append(c);
            }
            System.out.println(sb.toString());
        }



    }
}