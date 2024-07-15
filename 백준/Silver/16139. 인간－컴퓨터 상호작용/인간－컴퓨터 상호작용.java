import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for(int j=start; j<= end; j++){
                if(String.valueOf(str.charAt(j)).equals(s)){
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");

        }

        //print
        System.out.println(sb);

    }
}