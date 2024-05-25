import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        HashSet<Integer> hs; 
        // int[] cnt = new int[number+1];
        for(int i=1; i<= number; i++){
            hs = new HashSet<Integer>(); 
            hs.add(1);
            hs.add(i);
            for(int j=2; j<=Math.sqrt(i); j++){
                if(i%j==0) {
                    hs.add(j);
                    hs.add(i/j);
                }
            }
            if(hs.size() > limit) answer += power;
            else answer += hs.size(); 
            // cnt[i] = hs.size(); 
        }
       
        
        return answer;
    }
}