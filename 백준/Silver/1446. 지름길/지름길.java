import java.util.*;
import java.io.*;

// 운전해야하는 거리의 최솟값

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //지름길의 개수, 1 <= <=12
        int D = Integer.parseInt(st.nextToken()); //고속도로의 길이 1<= 10,000

        int[][] shortcut = new int[N][3];
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            shortcut[i][0] = Integer.parseInt(st.nextToken()); //시작 위치
            shortcut[i][1] = Integer.parseInt(st.nextToken()); //도착 위치
            shortcut[i][2] = Integer.parseInt(st.nextToken()); //지름길의 길이
        }

        int[] dp = new int[D+1];
        for(int i=0; i <= D; i++){
            dp[i] = i; //미리 길이 집어넣기
        }

        for(int i=1; i<=D; i++){
            dp[i] = Math.min(dp[i], dp[i-1]+1);
            for(int j=0; j<N; j++){
                if(shortcut[j][1] == i){
                    dp[i] = Math.min(dp[i], dp[shortcut[j][0]]+shortcut[j][2]);
                }
            }
        }

        System.out.println(dp[D]);
    }
}