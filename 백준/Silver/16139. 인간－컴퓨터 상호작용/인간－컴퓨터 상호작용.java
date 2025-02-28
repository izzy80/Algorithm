import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine()); //질문의 수
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[][] dp = new int[26+1][s.length()+1];
        for(int i=1; i <= 26;i++){
            for(int j=1; j <= s.length(); j++){
                if(i-1 == s.charAt(j-1)-'a'){
                    dp[i][j] = dp[i][j-1]+1;
                }
                else{
                    dp[i][j] =  dp[i][j-1];
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));

        for(int i=0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int cnt =0;
            char c = a.charAt(0);
            cnt = dp[c-'a'+1][r+1]-dp[c-'a'+1][l];
            sb.append(cnt).append("\n");

        }
        //print
        System.out.println(sb.toString());

    }
}