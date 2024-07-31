class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str = Integer.toString(n,k);
        if(!str.contains("0")) {
            if(isPrime(Long.parseLong(str))) return answer+1;
            else return answer;
        }
        String[] tmp = str.split("0");

        for(int i=0; i < tmp.length; i++){
            if(tmp[i].equals("")) continue;
            if(isPrime(Long.parseLong(tmp[i]))) answer++;
        }

        return answer;
    }

    public boolean isPrime(long n){
        if(n <= 1) return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}