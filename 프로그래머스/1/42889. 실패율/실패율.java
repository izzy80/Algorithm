import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
      int[] answer = {};

            HashMap<Integer, Double> hm = new HashMap<>();
            int[] failCnt = new int[N+2];
            int[] totalCnt = new int[N + 1];

            //스테이지에 머물러있는 플레이어의 수
            for(int stage : stages){
                failCnt[stage]++;
            }

            totalCnt[N] = failCnt[N]+failCnt[N+1];
            for(int i=N-1; i>=1; i--){
                totalCnt[i] = failCnt[i] + totalCnt[i+1];
            }

            for(int i=1; i<totalCnt.length; i++){
                if(failCnt[i] == 0 || totalCnt[i] ==0){
                    hm.put(i, 0.0);
                }
                else{
                    hm.put(i, (double) failCnt[i] / totalCnt[i]);
                }
            }

            //실패율 값으로 스테이지 번호를 내림차순
            List<Integer> list = new ArrayList<>(hm.keySet());
            Collections.sort(list, (o1, o2) -> Double.compare(hm.get(o2), hm.get(o1)));

            
            return list.stream().mapToInt(Integer::intValue).toArray();
    }
}