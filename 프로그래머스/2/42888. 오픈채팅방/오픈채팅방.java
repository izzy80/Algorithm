import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, String> hm = new HashMap<>(); //uuid, 이름
        for(int i=0; i < record.length; i++){
            String[] tmp = record[i].split(" ");
            if(tmp[0].equals("Enter") || tmp[0].equals("Change")){
                hm.put(tmp[1], tmp[2]);
            }
        }
        for(int i=0; i < record.length; i++){
            String[] tmp = record[i].split(" ");
            String nickname = hm.get(tmp[1]);
            String inout = "";
            if(tmp[0].equals("Enter")){
                inout = "들어왔습니다.";
            }
            else if(tmp[0].equals("Leave")){
                inout = "나갔습니다.";
            }
            
            if(tmp[0].equals("Change")){
                continue; 
            }
            else{
                answer.add(nickname+"님이 "+inout);
            }
        }
        return answer.toArray(new String[answer.size()]);
    }
}