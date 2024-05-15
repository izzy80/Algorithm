import java.util.*;
class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        HashMap<String, int[]> hm = new HashMap<>();
        hm.put("up",new int[]{0,1});
        hm.put("down",new int[]{0,-1});
        hm.put("left",new int[]{-1,0});
        hm.put("right",new int[]{1,0});
        
        int r = 0;
        int c = 0; 
        for(int i=0; i < keyinput.length; i++){
            int[] tmp = hm.get(keyinput[i]);
            System.out.println(Arrays.toString(tmp));
            
            int nr = r + tmp[0];
            int nc = c + tmp[1];
            
            if(nr < -(board[0]/2) || nr > board[0]/2 || nc < -(board[1]/2) || nc > board[1]/2) continue;
            r = nr; 
            c = nc; 
        }
        answer[0] = r;
        answer[1] = c;
        
        
        return answer;
    }
}