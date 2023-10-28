class Solution {
    public int solution(int n) {
   int ans = 0;
            long[] dp = new long[5001];
            int mod = 1000000007;
            dp[0] = 1;
            dp[2] = 3;

            if(n%2 != 0){//짝수일때만 실행, 홀수라면 실행 못 함
                return 0;
            }

            for(int i=4; i <= n; i+=2){
                dp[i] = dp[i-2]*3;
                for(int j=i-4;j>=0;j-=2){
                    dp[i] += dp[j]*2;
                }
                dp[i] = dp[i]%mod;
            }

            return (int)dp[n];
    }
}