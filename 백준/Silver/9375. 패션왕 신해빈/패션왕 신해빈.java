import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();

        for(int tc = 0; tc < T; tc++){
            //입을 수 있는 경우의 수
            //같은 종류의 의상은 하나만 입을 수 있다.
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            HashMap<String, Integer> hm = new HashMap<>();
            for(int i=0; i < N; i++){
                st = new StringTokenizer(br.readLine());

                String name = st.nextToken(); //의상 이름
                String kind = st.nextToken(); //의상 종류

                hm.put(kind,hm.getOrDefault(kind,0)+1);
            }


            int answer =1;
            for(int val : hm.values()){
                answer *= (val +1);
            }

            sb.append(answer-1).append("\n");

        }

        System.out.println(sb.toString());


    }
}