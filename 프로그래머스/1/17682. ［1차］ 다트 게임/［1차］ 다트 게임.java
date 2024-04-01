class Solution {
    public int solution(String dartResult) { 
           int answer = 0;

            String temp = "";
            int[] scores = new int[3];

            int idx =0;

            //문자열 1개씩 탐색
            for(int i=0; i < dartResult.length(); i++){
                switch (dartResult.charAt(i)){
                    case 'S':
                        scores[idx] = (int)Math.pow(Integer.parseInt(temp),1);
                        idx++;
                        temp ="";
                        break;
                    case 'D':
                        scores[idx] = (int)Math.pow(Integer.parseInt(temp),2);
                        idx++;
                        temp ="";
                        break;
                    case 'T':
                        scores[idx] = (int)Math.pow(Integer.parseInt(temp),3);
                        idx++;
                        temp ="";
                        break;
                    case '#':
                        scores[idx-1]*=-1;
                        break;
                    case '*':
                        scores[idx-1]*=2;
                        if(idx >1) scores[idx-2]*=2;
                        break;
                    default:
                        temp+=String.valueOf(dartResult.charAt(i));
                        break;
                }
            }
            for(int i=0; i < 3; i++){
                answer+=scores[i];
            }

            return answer;
    }
}