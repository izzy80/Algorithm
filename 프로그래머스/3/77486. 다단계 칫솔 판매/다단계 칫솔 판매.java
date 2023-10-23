import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> money = new HashMap<>();
        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            for(int i=0; i< enroll.length; i++){
                parent.put(enroll[i], referral[i]); //자식 - 부모
            }
            for(int i=0; i< seller.length; i++){
                share(seller[i], amount[i]*100);
            }

            int[] answer = new int[enroll.length];
            for (int i = 0; i < enroll.length; i++) {
                //지정된 키로 매핑된 값이 없으면 반환해야 하는 기본값
                answer[i] = money.getOrDefault(enroll[i], 0);
            }
            return answer;
        }

        private void share(String node, int sales) {
            int nextSales = sales / 10;
            money.put(node, money.getOrDefault(node, 0) + sales - nextSales);

            if (nextSales > 0 && parent.containsKey(node)) {
                share(parent.get(node), nextSales);
            }
        }
    }