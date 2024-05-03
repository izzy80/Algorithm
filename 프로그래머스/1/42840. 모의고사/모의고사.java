import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();

            int[][] order = new int[3][2];
            int[] answerOne = {1,2,3,4,5};
            int[] answerTwo = {2,1,2,3,2,4,2,5};
            int[] answerThree = {3,3,1,1,2,2,4,4,5,5};

            int oneCor = 0;
            int twoCor = 0;
            int threeCor = 0;

            for(int i=0; i < answers.length; i++){
                if(answers[i] == answerOne[i%5]) oneCor++;
                if(answers[i] == answerTwo[i%8]) twoCor++;
                if(answers[i] == answerThree[i%10]) threeCor++;
            }
            int max = Math.max(oneCor, Math.max(twoCor, threeCor));
            order[0][0] = 1;
            order[0][1] = oneCor;
            order[1][0] = 2;
            order[1][1] = twoCor;
            order[2][0] = 3;
            order[2][1] = threeCor;
            Arrays.sort(order, (int[] o1, int[] o2) -> {
                if(o1[1] == o2[1]){
                    return o1[0]-o2[0];
                }
                return o2[1]-o1[1];
            });

            int idx = 0;
            for(int i=0; i < order.length; i++){
                if(order[i][1] == max){
                    answer.add(order[i][0]);
                }
            }
            int[] ans = answer.stream().mapToInt(Integer::intValue).toArray();
            return ans;
    }
}