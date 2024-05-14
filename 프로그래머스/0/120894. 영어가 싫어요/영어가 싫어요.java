import java.util.*;

class Solution {
    public long solution(String numbers) {
        long answer = 0;
        HashMap<String,String> hm = new HashMap<>();
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
        
        for(String num : hm.keySet()){
            numbers = numbers.replaceAll(num, hm.get(num));
        }
        answer = Long.parseLong(numbers);
        
        
        return answer;
    }
}