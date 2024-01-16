import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> hm = new HashMap<>();
        String str = br.readLine();
        String[] arr = str.split(" ");
        for(String value : arr){
            int num = Integer.parseInt(value);
//            System.out.println(num);
            hm.put(num, hm.getOrDefault(num,0)+1);
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());

        str = br.readLine();
        arr = str.split(" ");
        
        for(String value : arr){
            int num = Integer.parseInt(value);
            sb.append(hm.getOrDefault(num,0)).append(" ");
        }

        System.out.println(sb.toString());
    }
}