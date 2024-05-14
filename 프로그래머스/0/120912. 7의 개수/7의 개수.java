class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int i=0; i < array.length; i++){
            String tmp = Integer.toString(array[i]);
            if(tmp.contains("7")){
               for(int j=0; j < tmp.length(); j++){
                   if(tmp.charAt(j) == '7') answer++;
               }
            }
        }
        
        
        
        
        return answer;
    }
}