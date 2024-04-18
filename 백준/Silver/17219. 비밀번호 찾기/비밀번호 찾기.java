import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //가능 최대인원
        int M = Integer.parseInt(st.nextToken()); //클릭한 사람

        HashMap<String, String> hm = new HashMap<>();
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String password = st.nextToken();
            hm.put(site, password);
        }

        for(int i=0; i < M; i++){
            String str = br.readLine();
            System.out.println(hm.get(str));
        }


    }
}