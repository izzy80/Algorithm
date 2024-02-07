class Solution {
    public int solution(String skill, String[] skill_trees) {
 int answer = -1;

            int cnt =0;
            for(String str : skill_trees){
                String cur = str.replaceAll("[^"+skill+"]",""); //BACDE -> BCD
                cnt += skill.indexOf(cur) == 0? 1:0; //인덱스가 0이어야 하는 이유는 C는 무저건 수행해야함.
            }
            return cnt;
    }
}