import java.util.Arrays;
class Solution {
    public int solution(int n, int[] money) {
           Arrays.sort(money); //정렬
            int moneyLen = money.length;
            int[][] dp = new int[moneyLen+1][n+1];

            dp[0][0] = 1;
            for(int i = 1; i<= moneyLen; i++){
                for(int j= 0; j <= n;j++){
                    if(money[i-1] > j){
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        dp[i][j] = dp[i-1][j]+dp[i][j-money[i-1]];
                    }

                }
            }
            return dp[moneyLen][n];
    }
}