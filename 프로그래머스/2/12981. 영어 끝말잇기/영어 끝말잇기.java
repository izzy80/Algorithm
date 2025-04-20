import java.util.*; 

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int N = words.length; 
        char end = words[0].charAt(words[0].length()-1);
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put(words[0],1);
        
        for (int i = 1; i < N; i++) {
            int num = hm.getOrDefault(words[i], 0);
            if (end != words[i].charAt(0) || num > 0 || words[i].length() == 1) {
                // 탈락자 발생
                answer[0] = (i % n) + 1; // 탈락자 번호
                answer[1] = (i / n) + 1; // 탈락자 차례
                return answer;
            }
            hm.put(words[i], num + 1);
            end = words[i].charAt(words[i].length() - 1);
        }
        
        // 탈락자가 없는 경우
        return new int[]{0, 0};
    }
}

