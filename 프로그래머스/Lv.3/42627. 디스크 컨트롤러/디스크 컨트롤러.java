import java.util.Arrays;
import java.util.PriorityQueue;
class Solution {
    public int solution(int[][] jobs) {
                        int answer = 0;

            // 요청시간 오름차순
            Arrays.sort(jobs, (o1,o2) -> o1[0] - o2[0]); //람다식 이용

            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

            int idx = 0;
            int cnt = 0;
            int end  = 0;
            int sum =0;

            while(cnt < jobs.length){
                //작업이 끝나는 시점까지 들어온 요청을 큐에 삽입
                while(idx < jobs.length && jobs[idx][0] <= end){
                    pq.add(jobs[idx++]);
                }

                //큐가 비어있다 => 현재 실행할 수 있는 작업X
                //다음 작업의 시작시간부터 시작.
                if(pq.isEmpty()){
                    end = jobs[idx][0];
                }
                // 작업이 끝나기 전 들어온 요청 중에서 가장 수행시간이 짧은 요청부터 수행
                else{
                    int[] cur = pq.poll();
                    //sum : 각 작업의 요청부터 종료까지 걸린 시간의 합계 
                    // 종료 시간 + 현재 시간 - 시작시간
                    sum += cur[1] + end - cur[0]; //하나의 작업이 요청한 시간부터 그 작업이 완료된 시간
                    // 그 다음에 시작할 작업의 시간을 현재시간+작업 종료 시간을 해주어 업데이트 
                    end += cur[1];
                    cnt++;
                }
            }
            return sum/jobs.length;
        }
}