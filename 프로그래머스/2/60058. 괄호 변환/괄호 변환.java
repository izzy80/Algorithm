import java.util.*;
class Solution {
        public String solution(String p) {
            return makeRight(p);
        }
        public String makeRight(String p){
            if(p.equals("")){
                return "";
            }
            int left_cnt = 0;
            int right_cnt = 0;
            String u = "";
            String v = "";
            for(int i=0; i < p.length(); i++){
                if(p.charAt(i) == '('){
                    left_cnt++;
                }
                else{
                    right_cnt++;
                }

                if(left_cnt == right_cnt){
                    u = p.substring(0,i+1);
                    v = p.substring(i+1,p.length());
                    break;
                }
//                System.out.println(u);
//                System.out.println(v);
            }
            if(checkRight(u)){
                //u가 올바른 문자열
                //v에 대해 재귀적으로 실행
                return u+makeRight(v);
            }
            return "("+makeRight(v)+")"+reverse(u);

        }

        public boolean checkRight(String p){
            Stack<Character> st = new Stack<>();
            if(p.equals("")) return true;
            for(int i=0; i < p.length(); i++){
                if(!st.isEmpty()){
                    if(p.charAt(i) == '('){
                        st.push('(');
                    }
                    else{ //)
                        if(st.peek() == '('){
                            st.pop();
                        }
                        else{
                            st.push(')');
                        }
                    }
                }
                else{//비어있음
                    st.push(p.charAt(i));
                }

            }
            if(st.size() >0 ) return false;
            else return true;
        }

    
    public static String reverse(String u){
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < u.length() - 1; i++) {
            // 나머지 문자열의 괄호 방향 뒤집기
            if (u.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }
}