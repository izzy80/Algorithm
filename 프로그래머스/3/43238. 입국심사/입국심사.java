import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
long answer = 0;

            //정렬
            Arrays.sort(times);

            long start = times[0]; // 가장 작은 수
            long end = (long)times[times.length-1]*n; //가장 오래 걸리는 수
            long sum;

            while(start <= end){
                long mid = (start + end) / 2;
                sum = 0;

                for(int time : times){
                    sum+=mid/time;
                }

                if(sum >= n){
                    answer = mid;
                    end = mid- 1;
                }
                else {
                    start = mid+1;
                }
            }
            return answer;
    }
}