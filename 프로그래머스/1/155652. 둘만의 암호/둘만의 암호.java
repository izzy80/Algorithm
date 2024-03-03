class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
            int[] alpha = new int[26];
            //skip하는 문자열에
            for(int i=0; i < skip.length(); i++){
                alpha[skip.charAt(i)-'a']++;
            }

             for(int i=0; i < s.length(); i++){
                int c = s.charAt(i)-'a';


                int cnt = 0;
                int start = c+1;
                while(true){
                    if(start >= 26)start %=26;
                    if(alpha[start] != 1){
                        cnt++;
                    }
                    if(cnt == index) break;
                    start++;
                }

                if(start >= 26)start %=26;
                char tmp = (char)(start+97);
                answer += String.valueOf(tmp);
            }
        return answer;
    }
}