import java.util.*;

class Solution {
    class Num {
        int number;
        int cnt;

        public Num(int number, int cnt){
            this.number = number;
            this.cnt = cnt;
        }
    }
    public int[] solution(String s) {
       
            HashMap<Integer, Integer> hm = new HashMap<>();

            int N = -1;  //마지막에 -1 해주어야 해서
            for(int i=0; i < s.length(); i++){
                if(s.charAt(i) == '{') N++;
            }
            int[] answer = new int[N];
            s = s.replaceAll("[\\{\\}]","");
            String[] numbers = s.split(",");

            for(int i=0; i < numbers.length; i++){
                hm.put(Integer.parseInt(numbers[i]), hm.getOrDefault(Integer.parseInt(numbers[i]),0)+1);
            }

            Num[] order = new Num[N];
            int idx = 0;
            for(int v : hm.keySet()){
                order[idx++] = new Num(v, hm.get(v));
            }
            //내림차순
            Arrays.sort(order, (o1,o2) -> {
                return o2.cnt-o1.cnt;
            });

            for(int i=0; i <N; i++){
                answer[i] = order[i].number;
            }

            return answer;
    }
}