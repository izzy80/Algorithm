import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0;
        long sum2 = 0;

        //int[]인 queue1의 합을 다 구한후, q1에 집어넣음.
        for(int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            q1.offer(queue1[i]);
        }
        //int[]인 queue2의 합을 다 구한후, q2에 집어넣음.
        for(int i = 0; i < queue2.length; i++) {
            sum2 += queue2[i];
            q2.offer(queue2[i]);
        }


        int count = 0;
        while(sum1 != sum2) { //sum1과 sum2가 같을 때까지
            count++;

            if(sum1 > sum2) {//sum1이 sum2보다 크면 q1에서 poll한 후 q2에 집어넣는다.
                int value = q1.poll();
                sum1 -= value;
                sum2 += value;
                q2.offer(value);
            } else {
                int value = q2.poll();
                sum1 += value;
                sum2 -= value;
                q1.offer(value);
            }
            if(count > (queue1.length + queue2.length) * 2) return -1;//이땐 더 순회해도 못만듦
        }
        return count;
    }
}