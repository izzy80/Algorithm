import java.util.Arrays;

class Solution {
     public int[] solution(int n, int s) {
            //n : 집합 원소의 수
            //s : 합이 되길 원하는 수
            if(n > s)
                return new int[]{-1};

            int[] answer = new int[n];

            int sum =0;
            for(int i=0; i<n; i++){
                answer[i] = s/n;
            }
            for(int i=0; i<s%n; i++)
                answer[i] ++;

            Arrays.sort(answer);

            return answer;
        }
    }