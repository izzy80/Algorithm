import java.util.Stack;
class Solution {
    boolean solution(String s) {
            boolean answer = true;
	        Stack<Character> st = new Stack<>();
	        
	        for(int i=0; i < s.length();i++) {
	        	char c = s.charAt(i);
	        	
	        	if(st.isEmpty()) {
	        		//비어있다면 무조건 추가
	        		st.add(c);
	        	}
	        	else {
	        		//비어있지 않다면
	        		if(c == ')') {
	        			if(st.peek() == '(') {
	        				st.pop();
	        			}
	        		}
	        		else {
	        			st.add(c);
	        		}
	        	}
	        }
	        
	        if(st.size() >0 ) {
	        	answer = false;
	        }
	        return answer;
    }
}