import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
         int answer = 0;
            Arrays.sort(reserve);
            Arrays.sort(lost);

            //도난 당하지 않은 학생 수
            answer = n - lost.length;

            //여벌의 체육복을 가져왔지만 도난당함
            for(int i=0; i< lost.length; i++){
                for(int j=0; j<reserve.length; j++){
                    if(lost[i] == reserve[j]){
                        answer++;
                        lost[i] = -1;
                        reserve[j] = -1;
                        break;
                    }
                }
            }

            //도난당했지만 체육복을 빌려줄 수 있음
            for(int i=0; i<lost.length; i++){
                for(int j=0; j < reserve.length; j++){
                    if(lost[i] == reserve[j]-1|| lost[i] == reserve[j]+1){
                        reserve[j] = -1;
                        lost[i]=-1;
                        answer++;
                        break;
                    }

                }
            }

            return answer;
    }
}