import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int N = progresses.length; 
        
        
        int[] arr = new int[N];
        for(int i=0; i < N ; i++){
            int tmp =  (100-progresses[i])/speeds[i];
            int mod = (100-progresses[i])%speeds[i];
            if(mod != 0) tmp+=1; 
            arr[i] = tmp; 
        }
        
        int cnt = 1;
        int prev = arr[0]; 
        int idx = 0; 
        ArrayList<Integer> answer = new ArrayList<>(); 
        for(int i=1; i < N; i++){
            int next = arr[i]; 
            if(prev < next){
                answer.add(cnt); 
                cnt = 1; 
                prev = next; 
            }
            else{
                cnt++; 
            }
            // System.out.println(cnt); 
        }
        answer.add(cnt); 
        // System.out.println(Arrays.toString(arr)); 
        
        return answer.stream()
                             .mapToInt(Integer::intValue)
                             .toArray();
    }
}