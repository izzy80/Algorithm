import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
          String answer = "Yes";
            Queue<String> q1 = new LinkedList<>();
            Queue<String> q2 = new LinkedList<>();

            for(int i=0; i < cards1.length; i++){
                q1.add(cards1[i]);
            }
            for(int i=0; i < cards2.length; i++){
                q2.add(cards2[i]);
            }

            int idx = 0; //goal의 idx
            while(idx < goal.length){
                boolean flag = false;
                if(!q1.isEmpty()){
                    if(q1.peek().equals(goal[idx])){
                        q1.poll();
                        flag = true;
                    }
                }
                if(!q2.isEmpty()){
                    if(q2.peek().equals(goal[idx])){
                        q2.poll();
                        flag = true;
                    }
                }
                if (!flag){
                    answer = "No";
                    break;
                }
                idx++;
            }

            return answer;
    }
}