import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new TreeMap<>();//treeMap이 순서대로 집어넣음

        for(int i=0; i< N; i++){
            String str = br.readLine();
            String[] tmp = str.split("[.]");

            if(map.containsKey(tmp[1])){//이미 존재하는 키라면
                map.put(tmp[1],map.getOrDefault(tmp[1],0)+1);
            }
            else{//처음들어간다면
                map.put(tmp[1], 1);
            }
        }

        for (String s : map.keySet()) {
            System.out.println(s+" "+map.get(s));
        }
    }
}