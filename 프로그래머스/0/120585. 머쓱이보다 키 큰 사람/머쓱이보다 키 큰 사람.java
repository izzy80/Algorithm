import java.util.*;

class Solution {
    public int solution(int[] array, int height) {
        int answer = (int)Arrays.stream(array).filter(i-> i > height).count();
        return answer;
    }
}