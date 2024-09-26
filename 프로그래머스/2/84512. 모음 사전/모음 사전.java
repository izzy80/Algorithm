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
         if(depth <= SIZE){
            if(depth == SIZE){
                if(cur.equals(correct)){
                    ans = cnt;
                    return;
                }
                cnt+=1;
//                System.out.println(cnt+"번째 "+cur);
                return;
            }
            if(cur.equals(correct)){
                ans = cnt;
                return;
            }
            cnt+=1;
//            System.out.println(cnt+"번째 "+cur);
        }

        DFS(cur+alpha[0],correct, depth+1);
        DFS(cur+alpha[1],correct, depth+1);
        DFS(cur+alpha[2],correct, depth+1);
        DFS(cur+alpha[3],correct, depth+1);
        DFS(cur+alpha[4],correct, depth+1);
    }
}