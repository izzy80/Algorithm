
import java.util.HashMap;

class Solution {
    public int solution(int[] a) {
               int answer = -1;

            //원소의 갯수 구하기 => max원소 => 스타 수열의 길이가 가장 길 가능성이 높다.
            HashMap<Integer, Integer> hm = new HashMap<>();
            for(int number : a){
                hm.put(number,hm.getOrDefault(number,0)+1);
            }

            //스타 수열 구하기
            for(int key : hm.keySet()) {
                if(hm.get(key) <= answer) continue;
                int count = 0;

                for(int i=0; i<a.length-1; i++) {
                    if(a[i] != key && a[i+1] != key) continue;
                    if(a[i] == a[i+1]) continue;
                    count++;
                    i++;
                }
                answer = Math.max(answer, count);
            }


            return answer*2;
    }
}