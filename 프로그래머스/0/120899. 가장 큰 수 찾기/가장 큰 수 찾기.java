import java.util.*;

class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        int[] arr = array.clone(); 
        Arrays.sort(arr);
        answer[0] = arr[arr.length-1];
        for(int i=0; i < array.length; i++){
            if(array[i] == answer[0]) answer[1] = i;
        }
        return answer;
    }
}