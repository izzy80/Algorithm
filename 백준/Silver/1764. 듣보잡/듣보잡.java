import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //듣도 못한 사람의 수
        int M = Integer.parseInt(st.nextToken()); //보도 못한 사람의 수

        HashMap<String, Integer> hm = new HashMap<>();
        List<String> name = new ArrayList<>();
        for(int i=0; i < N+M ; i++){
            String tmp = br.readLine();
            if(hm.getOrDefault(tmp,0) != 0) name.add(tmp);
            hm.put(tmp, hm.getOrDefault(tmp,0)+1);
        }

        //sort
        Collections.sort(name);

        //출력
        System.out.println(name.size());
        for(int i=0; i < name.size(); i++){
            System.out.println(name.get(i));
        }
    }
}