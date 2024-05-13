import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        //1. 정렬
        Arrays.sort(array);
       
        int diff = Integer.MAX_VALUE;
        for(int i=0; i < array.length; i++){
            if(Math.abs(array[i]-n) < diff) {
                diff = Math.abs(array[i]-n);
                answer = array[i];
            }
        }
    
        return answer;
    }
}