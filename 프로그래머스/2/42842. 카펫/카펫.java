class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        for(int i=3; i <= total; i++){
            int j =0; 
            if(total%i == 0){
                if(i > total/i) break; 
                j = total/i;
                int cal = i*2 + (j-2)*2;
                // System.out.println(cal);
                if(cal == brown){
                    answer[0] = j;
                    answer[1] = i;
                }
            }
        }
        return answer;
    }
}