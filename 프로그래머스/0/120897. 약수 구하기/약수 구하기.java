import java.util.*;

class Solution {
    public int[] solution(int n) {
        HashSet<Integer> hs = new HashSet<>(); 
        for(int i=1; i <=Math.sqrt(n); i++){
            if(n%i == 0) {
                hs.add(i);
                hs.add(n/i);
            }
        }
        
        return hs.stream().mapToInt(i->i).sorted().toArray();
    }
}