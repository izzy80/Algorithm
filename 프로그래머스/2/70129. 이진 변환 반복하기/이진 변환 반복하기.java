class Solution {
    static int zero;//모든 0의 개수 
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 0; //이진변환의 횟수
        zero = 0; 
        
        while(!s.equals("1")){
            //0제거
            for(int i=0; i < s.length(); i++){
                if(s.charAt(i) == '0'){
                    zero++;
                }
            }
            s = s.replace("0","");
            String binary = Integer.toBinaryString(s.length());
            s = binary; 
            cnt++;
        }
        
        answer[0] = cnt;
        answer[1] = zero; 
        
        return answer;
    }
}