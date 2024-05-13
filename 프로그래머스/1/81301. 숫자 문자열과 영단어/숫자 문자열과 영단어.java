import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        HashMap<String, String> hm = new HashMap<>();
        hm.put("zero","0");
        hm.put("one","1");
        hm.put("two","2");
        hm.put("three","3");
        hm.put("four","4");
        hm.put("five","5");
        hm.put("six","6");
        hm.put("seven","7");
        hm.put("eight","8");
        hm.put("nine","9");
        StringBuilder sb = new StringBuilder(); 
        
        for(String tmp : hm.keySet()){
            s = s.replaceAll(tmp,hm.get(tmp));
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}