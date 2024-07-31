import java.util.*;

class Solution {
    public int[] solution(String msg) {
         //1. HashMap<알파벳, 인덱스> : hm에 A~Z까지 집어넣기.
            HashMap<String,Integer> hm = new HashMap<>();
            for(int i=0; i < 26;i++){
                hm.put(String.valueOf((char)('A'+i)),i+1);
            }

            ArrayList<Integer> answer = new ArrayList<>();
            int idx = 0;
            while(idx + 1 < msg.length()){//msg길이보다 작을때까지
                String cur = "";
                String pre = String.valueOf(msg.charAt(idx));
                
                for(int i = 1; idx + i <= msg.length(); i++){
                    cur = msg.substring(idx,idx+i);
                    if(!hm.containsKey(cur)){//cur이 없다면 cur을 hm에 집어넣는다.
                        hm.put(cur, hm.size()+1);
                        break;
                    }
                    pre = cur;
                }
                answer.add(hm.get(pre));
                idx = idx+pre.length();
            }

            if(idx == msg.length() - 1){
                answer.add(hm.get(String.valueOf(msg.charAt(idx))));
            }
            return answer.stream().mapToInt(i -> i).toArray();
    }
}