import java.util.*;

class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        HashMap<String, String> hm = new HashMap<>();
        for(int i=0; i < db.length; i++){
            hm.put(db[i][0],db[i][1]);
        }
        
        if(hm.getOrDefault(id_pw[0],"fail").equals("fail")){//id 없음
            answer = "fail";
        }
        else{
            //id는 존재
            String pw = hm.get(id_pw[0]);
            if(pw.equals(id_pw[1])){
                //pw도 같음
                answer = "login";
            }
            else{
                answer = "wrong pw";
            }
        }
        
        
        return answer;
    }
}