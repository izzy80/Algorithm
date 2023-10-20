import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
            Arrays.sort(lottos);
            Arrays.sort(win_nums);

            int[] visited_l = new int[46];
            int[] visited_w = new int[46];

            for(int i=0; i <lottos.length; i++){
                visited_l[lottos[i]]++;
                visited_w[win_nums[i]]++;
            }

            int same = 0;
            for(int i=0; i< visited_l.length ; i++){
                if(visited_l[i] == visited_w[i] && visited_l[i] != 0){
                    same++;
                }
            }
//            System.out.println(same);
//            System.out.println(visited_l[0]);

            int max = same;
            int min = same;
            if(visited_l[0] > 0){
                max+=visited_l[0];
            }

            int minr = rate(min);
            int maxr = rate(max);

            int[] answer = {maxr,minr};
            return answer;
        }

        private int rate(int num) {
            switch(num){
                case 6:
                    return 1;
                case 5 :
                    return 2;
                case 4 :
                    return 3;
                case 3 :
                    return 4;
                case 2 :
                    return 5;
                default:
                    return 6;
            }

        }
}