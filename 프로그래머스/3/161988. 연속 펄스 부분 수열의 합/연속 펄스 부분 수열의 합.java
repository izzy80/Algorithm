class Solution {
    public long solution(int[] sequence) {
           long ans;
            int len = sequence.length;

            int[] parr = new int[len]; //+부터 시작
            int[] marr = new int[len]; //-부터 시작

            long[] pdp = new long[len];
            long[] mdp = new long[len];

            int p = 1;
            for(int i=0; i<len;i++){
                parr[i] = sequence[i]*p;
                p*=-1;
                marr[i] = sequence[i]*p;
            }

            pdp[0] = parr[0];
            mdp[0] = marr[0];

            ans = Math.max(pdp[0], mdp[0]);

            for(int i=1; i<len; i++){
                pdp[i] = Math.max(pdp[i-1]+parr[i], parr[i]);
                mdp[i] = Math.max(mdp[i-1]+marr[i], marr[i]);

                long max = Math.max(pdp[i], mdp[i]);
                ans = Math.max(max, ans);
            }
            return ans;
    }
}