import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
      int answer = 0;

            HashMap<String, Integer> hm1 = new HashMap<>();
            HashMap<String, Integer> hm2 = new HashMap<>();

            HashSet<String> union = new HashSet<>();
            HashSet<String> intersection = new HashSet<>();

            for(int i=0; i < str1.length()-1; i++){
                String str = str1.substring(i, i+2).toUpperCase();
                if(!str.matches("[A-Z]*") ) continue;
                hm1.put(str, hm1.getOrDefault(str,0)+1);
                union.add(str);
            }
            for(int i=0; i < str2.length()-1; i++){
                String str = str2.substring(i, i+2).toUpperCase();
                if(!str.matches("[A-Z]*")) continue;
                hm2.put(str, hm2.getOrDefault(str,0)+1);
            }
            
            for(String str : hm2.keySet()){
                if(union.add(str)){
                    union.add(str);
                }
                else{//이미 존재한다면
                    intersection.add(str);
                }
            }
                if(hm1.isEmpty() && hm2.isEmpty() || intersection.isEmpty() && union.isEmpty()) return 65536;
        
            //intersection
            int up = 0;
            for(String s : intersection){
                up += Math.min(hm1.get(s), hm2.get(s));
            }
            
            //union
            int down = 0;
            for(String s : union){
                down += Math.max(hm1.getOrDefault(s, 0), hm2.getOrDefault(s, 0));
            }
            answer = (int)(((double)up/down)*65536);
        
        return answer;
        }
}