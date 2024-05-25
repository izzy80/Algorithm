import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> hm = new HashMap<>(); 
        for(int i : tangerine){
            hm.put(i, hm.getOrDefault(i, 0)+1);
        }
        List<Integer> keySet = new LinkedList<>(hm.keySet());
        keySet.sort((o1,o2) -> hm.get(o2).compareTo(hm.get(o1)));
        
        int tCnt =0; 
        for(int key : keySet){
            if(tCnt >= k) break; 
            tCnt += hm.get(key);
            answer++; 
        }
        return answer;
    }
}