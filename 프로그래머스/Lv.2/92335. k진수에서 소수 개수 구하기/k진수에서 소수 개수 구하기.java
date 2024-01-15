class Solution {
    public int solution(int n, int k) {
         int answer = 0;
            //1. 진수 구하기
            StringBuilder sb = new StringBuilder();
            while(n > 0){
                sb.append(n%k);
                n/=k;
            }
            sb.reverse();
//            System.out.println(sb.toString());

            //2. 소수 구하기
            String[] arr = sb.toString().split("0");

            for(String str : arr){
                if(str.equals("")){
                    continue;
                }
                long checkNum = Long.parseLong(str);
                if(isPrime(checkNum)){
                    answer++;
                }
            }
            return answer;
    }
       private boolean isPrime(long checkNum) {
            if(checkNum < 2) return false;
            for(int i=2; i<=Math.sqrt(checkNum);i++){
                if(checkNum %i == 0){
                    return false;
                }
            }
            return true;
        }
}