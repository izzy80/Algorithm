import java.util.*;

class Solution {
    public String solution(String letter) {
        String[] mos = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashMap<String,String> hm = new HashMap<>(); 
        for(int i=0; i< mos.length; i++){
            hm.put(mos[i], String.valueOf((char)(97+i)));
        }
        StringBuilder sb = new StringBuilder();
        String[] str = letter.split(" ");
        for(String st : str){
            sb.append(hm.get(st));
        }
        return sb.toString();
    }
}