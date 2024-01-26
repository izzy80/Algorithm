import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
      List<Integer> list = new LinkedList<>();
            Queue<Integer> q = new LinkedList<>();

            for(int i=0 ; i < progresses.length; i++){
                double num = (100 - progresses[i])/(double)speeds[i];
                int numm = (100 - progresses[i])/speeds[i];

                if(num == numm) {
                    q.add(numm);
                }
                else{
                    q.add(numm+1);
                }
            }
//            System.out.println(q.toString());

            int now = q.poll();
            int cnt = 1;
            while(!q.isEmpty()){
                if(now < q.peek()){
                    list.add(cnt);
                    cnt = 1;
                    now = q.poll();
                }
                else {
                    cnt++;
                    q.poll();
                }
            }
            list.add(cnt);


            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }