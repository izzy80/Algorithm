import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int N = emergency.length; 
        int[] answer = new int[N];
        HashMap<Integer, Integer> hm = new HashMap<>(); 
        int[] arr = emergency.clone();
        Arrays.sort(arr);
        for(int i=N-1; i >= 0; i--){
            hm.put(arr[i], N-i);
        }
         for(int i=0; i < N; i++){
            answer[i] = hm.get(emergency[i]);
        }
        
        
        
        return answer;
    }
}