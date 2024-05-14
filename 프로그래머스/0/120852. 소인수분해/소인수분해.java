import java.util.*;

class Solution {
    public int[] solution(int n) {
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i=2; i <= n; i++){
            if(n%i == 0) {
                while(n%i == 0){
                    n/=i;
                }
                hs.add(i);
            }
        }
        int[] answer = hs.stream().mapToInt(i->i).toArray();
        Arrays.sort(answer);
        
         
        return answer;
    }
}