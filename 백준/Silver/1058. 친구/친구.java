import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 100000000;
    static int[][] cost = new int[51][51];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=1; i <= N; i++){
            String str = br.readLine();
            for(int j=1;j <= N; j++){
                char c = str.charAt(j-1);
                if(c == 'Y'){
                    cost[i][j] = 1;
                }
                else{
                    cost[i][j] = INF;
                }

            }
        }

        //solve
        //플로이드 와샬
        for(int i = 1; i <= N;i++){
            for(int j = 1;j<=N;j++){
                for(int k = 1;k<=N;k++){
                    if(j == k) continue;
                    cost[j][k] = Math.min(cost[j][k],cost[j][i]+cost[i][k]);
                }
            }
        }


        int max = 0;

        for (int i = 1; i <= N ; i++) {
            int cnt = 0;
            for (int j = 1; j <= N ; j++) {
                if(cost[i][j] == 2 || cost[i][j] == 1){
                    cnt++;
                }
            }
            max = Math.max(max,cnt);
        }

        System.out.println(max);



    }
}