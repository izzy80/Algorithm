import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
                    String answer = "";

            HashMap<String, Integer> hm = new HashMap<>();
            for(String value : participant){
                hm.put(value, hm.getOrDefault(value,0)+1);
            }

            for(String value : completion){
                hm.put(value, hm.get(value)-1);
            }
                
            for(String key : hm.keySet()){
                if(hm.get(key) != 0){
                    answer = key;
                    break;
                }
            }
            return answer;
    }
}