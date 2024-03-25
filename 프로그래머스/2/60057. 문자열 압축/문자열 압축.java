class Solution {
    public int solution(String s) {
       int answer = s.length();
            //가능한 경우의 수 : 2~ s.length/2
            //반절은 짝궁이 나올 수 있으니까
            for(int i=1; i<=s.length()/2; i++){//가능한 경우의 수를 탐색
                String target = s.substring(0,i);
                String curStr = ""; //현재 문자열
                int cnt = 1; //압축 카운트
                StringBuilder sb = new StringBuilder();

                for(int start = i; start <= s.length(); start += i){
                    //비교할 현재 문자열
                    //다음 자를 문자열의 길이가 단위보다 작으면 남은 글자를 저장
                    if(start + i >= s.length()){
                        curStr = s.substring(start, s.length());
                    }
                    else{
                        curStr = s.substring(start, start + i);
                    }

                    //문자열이 같으면 압축카운트 증가
                    if(curStr.equals(target)){
                        cnt++;
                    }
                    else if(cnt == 1){//다르면 압축된 문자열을 추가하고 타겟 패턴 변경
                        sb.append(target);
                        target = curStr;
                    }
                    else{
                        sb.append(cnt).append(target);
                        target = curStr;
                        cnt = 1;
                    }
                }
                //자르고 마지막에 남은 문자열 추가
                if(i != target.length()) sb.append(target);
                answer = Math.min(answer, sb.toString().length());

            }

            return answer;
        }
}