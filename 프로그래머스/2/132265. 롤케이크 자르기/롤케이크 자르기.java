import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashSet<Integer> hs = new HashSet<>(); 
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        
        for(int i=0; i < topping.length; i++){
            hm.put(topping[i], hm.getOrDefault(topping[i], 0)+1);
        }
        for (int i = 0; i < topping.length; i++) {
            hs.add(topping[i]);
            hm.put(topping[i], hm.get(topping[i]) - 1);
            if (hm.get(topping[i]) == 0) {
                hm.remove(topping[i]);
            }
            if (hs.size() == hm.size()) {
                answer++;
            }

        }
        
        return answer;
    }
}