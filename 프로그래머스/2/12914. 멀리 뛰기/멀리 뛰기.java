/*
단순 dfs 시초
dp의 메모이제이션을 이용하자 
*/
    
class Solution {
    static long answer; 
    public long solution(int n) {
        answer = 0;
        long[] dp = new long[2000+1];
        

        dp[1] = 1; 
        dp[2] = 2;
        dp[3] = 3; 
        if(n >3){
            for(int i= 4; i<= n; i++){
            dp[i] = (dp[i-1]+dp[i-2])%1234567;
            }
        }
        return dp[n];
    }
}