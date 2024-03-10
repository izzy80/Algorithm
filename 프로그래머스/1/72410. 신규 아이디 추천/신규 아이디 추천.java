class Solution {
    public String solution(String new_id) {
         //1.대문자 -> 소문자
            String answer = new_id.toLowerCase();

            //2.정규식에 들어가는 문자 제외 제거
            answer = answer.replaceAll("[^-_.a-z0-9]", "");

            //3.마침표가 2번 이상 반복되면 .로 변환
            answer = answer.replaceAll("\\.+",".");

            //4. 마침표가 처음과 끝에 있다면 제거
            answer = answer.replaceAll("^[.]|[.]$","");

            //5. 빈 문자열이라면 "a" 대입
            if(answer.length() == 0){
                answer="a";
            }

            //6. 문자열 길이가 16이상이면 첫 15개의 문자를 제외한 나머지 문자 제거
            //끝 문자가 .이면 제거
            if(answer.length() > 15){
                answer = answer.substring(0,15);
                answer = answer.replaceAll("[.]$","");
            }

            //7. 문자열의 길이가 2 이하면 길이가 3이 될때까지 마지막 문자열 추가 
            while(answer.length() < 3){
                answer += answer.charAt(answer.length() - 1);
            }

        return answer;
    }
}