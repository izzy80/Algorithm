import java.util.*;
class Solution {
    public int solution(int[] array) {
        
        Arrays.sort(array);
        int len = array.length;
        int answer = array[(len-1)/2];
        
        
        return answer;
    }
}