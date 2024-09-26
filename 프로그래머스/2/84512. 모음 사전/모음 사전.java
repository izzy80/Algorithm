import java.util.*;

class Solution {
    static int cnt = 0;
    static int ans = 0;
    static String[] alpha = {"A","E","I","O","U"};
    static int SIZE = 5;
    
    public int solution(String word) {
        DFS("",word,0);
        return ans;
    }
    
    public static void DFS(String cur, String correct,int depth){
       if(cur.equals(correct)){
            ans = cnt;
            return;
        }
        if(depth > SIZE) return;
        cnt+=1;
        
        for(int i=0; i < SIZE; i++){
            DFS(cur+alpha[i],correct, depth+1);
        }
    }
}