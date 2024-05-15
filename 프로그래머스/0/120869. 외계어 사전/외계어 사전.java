import java.util.*;

class Solution {
    static String[] spells;
    static HashMap<String,Integer> hm;
    static int answer;
    public int solution(String[] spell, String[] dic) {
        answer = 2;
        spells = spell;
        hm = new HashMap<>(); 
        for(int i=0; i < dic.length; i++){
            hm.put(dic[i], 1);
        }        
        boolean[] visited = new boolean[spell.length];
        dfs(0,"",visited);
        
        return answer;
    }
    public void dfs(int depth, String tmp, boolean[] visited){
        if(depth == spells.length){
            if(hm.getOrDefault(tmp,0) == 1){
                answer = 1; 
            }
            // System.out.println(tmp);
            return; 
        }
        for(int i=0; i < spells.length; i++){
            if(!visited[i]){
                visited[i] = true; 
                dfs(depth+1, tmp+spells[i], visited);
                visited[i]=false;
            }
        }
        // dfs(depth+1, tmp+spells[idx], idx+1);
        // dfs(depth+1, tmp, idx+1);
        
    }
}