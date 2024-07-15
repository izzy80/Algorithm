import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase(); // 모두 대문자로 
		str2 = str2.toUpperCase();
        
        // System.out.println(str1);
        // System.out.println(str2);
        
        HashMap<String,Integer> hm1 = new HashMap<>();
        HashMap<String,Integer> hm2 = new HashMap<>();
        HashMap<String,Integer> intersection = new HashMap<>();
        HashMap<String,Integer> union = new HashMap<>();
        
        for(int i = 0; i < str1.length()-1; i++) {
			char a = str1.charAt(i);
			char b = str1.charAt(i+1);

			// 문자만 가진 경우만 추가 
			if(Character.isLetter(a) && Character.isLetter(b)) {
				String str = Character.toString(a) + Character.toString(b);
				hm1.put(str,hm1.getOrDefault(str,0)+1);
			}
		}
        
         for(int i = 0; i < str2.length()-1; i++) {
			char a = str2.charAt(i);
			char b = str2.charAt(i+1);

			// 문자만 가진 경우만 추가 
			if(Character.isLetter(a) && Character.isLetter(b)) {
				String str = Character.toString(a) + Character.toString(b);
				hm2.put(str,hm2.getOrDefault(str,0)+1);
			}
		}
        
        //교집합
        for(String key : hm1.keySet()){
            if(hm2.getOrDefault(key,0)!= 0){
                intersection.put(key,Math.min(hm1.get(key),hm2.get(key)));
                union.put(key,Math.max(hm1.get(key),hm2.get(key)));
            }
            else{//합집합
                union.put(key,hm1.get(key));
            }
        }
        //합집합
        for(String key : hm2.keySet()){
            if(hm1.getOrDefault(key,0)== 0){
                union.put(key,hm2.get(key));
            }
        }
        
        double up = 0.0;
        double down = 0.0; 
        for(String key : union.keySet()){
            down += union.get(key);
        }
         for(String key : intersection.keySet()){
            up += intersection.get(key);
        }
        double jak = 1; 
        if(down != 0.0){
            jak = up/down;
        }
        answer = (int)(jak*65536);
        
        
        return answer;
    }
}