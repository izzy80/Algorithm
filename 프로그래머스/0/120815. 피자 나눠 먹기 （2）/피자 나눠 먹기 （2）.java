class Solution {
    public int solution(int n) {
        int answer = 0;
        int pizza = 6;
        while(pizza > 0){
            if(pizza%n == 0) {
                answer = pizza/6; 
                pizza%=n;
            }
            else{
                pizza+=6;
            }
        }
        return answer;
    }
}