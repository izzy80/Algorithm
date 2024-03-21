import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> hm = new TreeMap<>();
        int max = Integer.MIN_VALUE;
        for(int i=0; i < N; i++){
            String tmp = br.readLine();
            int num = hm.getOrDefault(tmp,0)+1;
            max = Math.max(max, num);
            hm.put(tmp, num);
        }

        for (String s : hm.keySet()) {
            if(hm.get(s) == max){
                System.out.println(s);
                break;
            }
        }

    }
}