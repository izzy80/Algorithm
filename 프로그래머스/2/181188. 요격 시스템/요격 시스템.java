import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] targets) {
               int answer = 0;

        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1]; //x축 끝점 기준 오름차순
            }
        });



        int now = Integer.MIN_VALUE;
        for(int i=0; i<targets.length; i++){
            if(now < targets[i][0]) {
                now  = targets[i][1]-1;
//                System.out.println("now = "+now);
                answer++;
            }
        }

        return answer;
    }
}