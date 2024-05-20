class Solution {
    public String solution(String s, int n) {
        String[] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p",
                         "q","r","s","t","u","v","w","x","y","z"};
        StringBuilder sb = new StringBuilder(); 
        for(int i = 0; i < s.length(); i++){
            if(Character.isUpperCase(s.charAt(i))){//대문자?
                char c = String.valueOf(s.charAt(i)).toLowerCase().charAt(0); //소문자 
                sb.append(String.valueOf(alpha[((c-'a')+n)%26]).toUpperCase());
            }
            else if (s.charAt(i) == ' '){
               sb.append(" ");
            }
            else{
                sb.append(alpha[((s.charAt(i)-'a')+n)%26]);
            }

        }      
        return sb.toString();
    }
}