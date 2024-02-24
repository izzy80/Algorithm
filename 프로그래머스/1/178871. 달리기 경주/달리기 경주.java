import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> hm = new HashMap<>(); //이름, 순위
        
         for(int i=0; i<players.length; i++){
            hm.put(players[i], i);
        }

         for(int i=0; i < callings.length; i++) {
            String tmp = callings[i];
            int index = hm.get(tmp); //불린 아이의 index가져옴

            String change = players[index-1];
            players[index-1] = tmp;
            players[index] = change;

            hm.put(tmp, hm.get(tmp)-1);
            hm.put(change, hm.get(change)+1);
        }
        
        return players;
    }
}