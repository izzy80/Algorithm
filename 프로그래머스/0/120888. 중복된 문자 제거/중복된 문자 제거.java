import java.util.*;

class Solution {
    public String solution(String my_string) {
        LinkedHashSet<String> hs = new LinkedHashSet<>();
        for(int i=0; i < my_string.length(); i++){
            hs.add(String.valueOf(my_string.charAt(i)));
        }
        String ans = "";
        for(String a : hs){
            ans+=a;
        }
        return ans;
    }
}