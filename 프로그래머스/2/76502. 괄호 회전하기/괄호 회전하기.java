import java.util.Stack;

class Solution {
    public int solution(String s) {
       int answer = 0;

            int len = s.length();

            for(int i=0; i < len; i++){
                if(checkString(s)){//true면 answer++;
                    answer++;
                }
                s = s.substring(1,len)+s.substring(0,1);
//                System.out.println(s);
            }
            return answer;
    }
    
    private boolean checkString(String s) {
            Stack<Character> st = new Stack<>();

            for(int i=0; i< s.length(); i++){
                if(st.isEmpty()){
                    st.push(s.charAt(i));
                }
                else{//안 비어있다면
                    if(s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{'){
                        st.push(s.charAt(i));
                    }
                    else{//닫히는 아이들
                        if(s.charAt(i) == ']'){
                            if(st.peek() == '['){
                                st.pop();
                            }
                        }
                        else if(s.charAt(i) == ')'){
                            if(st.peek() == '('){
                                st.pop();
                            }
                        }
                        else{
                            if(st.peek() == '{'){
                                st.pop();
                            }
                        }
                    }
                }
            }
            if(st.isEmpty()){
                return true;
            }
            return false;
        }
}