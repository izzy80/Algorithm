class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int fac = 1; 
        int num = 1; 
        while(true){
            fac *=num;
              if(fac == n) {
                answer = num;
                break;
            }
            else if(fac > n){
                answer = num-1; 
                break;
            }
            num++;
        }
        return answer;
    }
}