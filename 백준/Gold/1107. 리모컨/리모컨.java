import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //이동하려고 하는 채널
        int M = Integer.parseInt(br.readLine()); //고장난 버튼의 개수

        //고장난 버튼
        boolean[] broken = new boolean[10];
        if(M > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i < M; i++){
                int num = Integer.parseInt(st.nextToken());
                broken[num] = true;
            }
        }


        int ans = Math.abs(100-N);

        for(int i=0;i<=999999;i++){

            String cur = Integer.toString(i);
            boolean check=false;

            for(int j=0;j<cur.length();j++){
                if(broken[cur.charAt(j) - '0']){
                    check=true; // 고장난 버튼이면 break
                    break;
                }
            }
            if(!check) // 고장안났으면 target 까지 거리 계산해서 갱신
                ans = Math.min(ans,cur.length()+Math.abs(i-N));
        }
        System.out.println(ans);
    }
}