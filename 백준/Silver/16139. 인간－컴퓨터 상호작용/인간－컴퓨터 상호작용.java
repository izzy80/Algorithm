import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine()); //질문의 수
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            String tmp = s.substring(l,r+1);
            int cnt =0;
            for(int j=0; j < tmp.length(); j++){
                if(String.valueOf(tmp.charAt(j)).equals(a)){
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");

        }
        //print
        System.out.println(sb.toString());

    }
}