class Solution {
    public String solution(String X, String Y) {
       StringBuilder sb = new StringBuilder();
            String answer = "";

            int[] xCnt = new int[10];
            int[] yCnt = new int[10];

            for(int i=0; i < X.length(); i++){
                xCnt[X.charAt(i)-'0']++;
            }

            for(int i=0; i < Y.length(); i++){
                yCnt[Y.charAt(i)-'0']++;
            }

            boolean flag = false; //다른 숫자

            for(int i=xCnt.length-1; i >= 0; i--){
                if(xCnt[i] != 0 && yCnt[i] != 0){
                    if(i != 0) flag = true;
                    if(xCnt[i] >= yCnt[i]){
                        while(yCnt[i] > 0){
                            sb.append(String.valueOf(i));
                            yCnt[i]--;
                        }
                    }
                    else{ //yCnt[i]가 더 큼
                        while(xCnt[i] > 0){
                            sb.append(String.valueOf(i));
                            xCnt[i]--;
                        }
                    }
                }
            }

            if(sb.toString().equals("")){
                answer = "-1";
            }
            else if(!flag){
                answer = "0";
            }
            else{
                answer = sb.toString();
            }
            return answer;
        }
}