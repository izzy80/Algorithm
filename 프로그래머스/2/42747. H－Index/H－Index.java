import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int len = citations.length;
        
        Arrays.sort(citations);
        int answer = 0; 
        for(int i=0; i < len ; i++){
            int h = len - i; 
            
            if(citations[i] >= h) {
                answer = h;
                break;
            }
            
        }
        
        return answer;
    }
}