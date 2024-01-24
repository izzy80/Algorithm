import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> st = new Stack<>();
            for (int i = 0; i < arr.length; i++) {
                if(st.isEmpty() || st.peek() != arr[i]){
                    st.add(arr[i]);
                }
            }
            int[] answer = new int[st.size()];
            int index = 0;
            for (int value : st) {
                answer[index++] = value;
            }
            return answer;
        }
    }