import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //포켓몬의 개수
        int M = Integer.parseInt(st.nextToken()); //맞춰야할 문제의 개수
        String[] str = new String[N+1];
        HashMap<String,Integer> hm = new HashMap<>();

        for(int i=1; i <= N; i++){
            String tmp = br.readLine();
            str[i] = tmp;
            hm.put(tmp, i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < M; i++){
            String word = br.readLine();

            if(Character.isAlphabetic(word.charAt(0))){
                //알파벳이면
                sb.append(hm.get(word)).append("\n");
            }
            else{
                //숫자면
                int num = Integer.parseInt(word);
                sb.append(str[num]).append("\n");
            }
        }

        System.out.println(sb.toString());


    }
}