import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";

            HashMap<String, Integer> hm = new HashMap<>();
            String[] name = {"R","T","C","F","J","M","A","N"};

            hm.put("R",0);
            hm.put("T",0);
            hm.put("C",0);
            hm.put("F",0);
            hm.put("J",0);
            hm.put("M",0);
            hm.put("A",0);
            hm.put("N",0);



            for(int i=0; i <survey.length; i++){
                //앞이 비동의, 뒤가 동의
                if(choices[i] == 4) continue;
                if(choices[i] > 4){ //4보다 크면 동의
                    String str = String.valueOf(survey[i].charAt(1));
                    hm.put(str, hm.get(str)+(choices[i]-4));
                }
                else{ //choices[i] < 4
                    String str = String.valueOf(survey[i].charAt(0));
                    hm.put(str, hm.get(str)+(4 - choices[i]));
                }
            }

            for(int i=0; i < name.length;i+=2){
                if(hm.get(name[i]) < hm.get(name[i+1])){
                    answer += name[i+1];
                }
                else{
                    answer += name[i];
                }
            }
            return answer;
    }
}