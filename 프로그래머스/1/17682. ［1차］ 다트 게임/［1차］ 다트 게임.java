import java.util.*;

class Solution {
    public int solution(String dartResult) {
         int answer = 0;

            int idx = 0;
            ArrayList<Integer> arr = new ArrayList<>();

            while(idx < dartResult.length() -1){
                int curIdx = 0;
                int curNumber = 0;

                for(int i = idx; i < dartResult.length(); i++){
                    char c = dartResult.charAt(i);
                    if(c == 'S' || c == 'D' || c == 'T' ){
                        curIdx = i;
                        int number = Integer.parseInt(dartResult.substring(idx,curIdx));//마지막 idx+1까지 가져옴
                        //curIdx에 S나 D나 T가 있으니까 idx부터 curIdx-1까지가 숫자이다.
                        switch(c){
                            case 'S' :
                                curNumber = number;
                                break;
                            case 'D':
                                curNumber = (int)Math.pow(number,2);
                                break;
                            case 'T':
                                curNumber = (int)Math.pow(number,3);
                                break;
                        }
                        break; //break되면 현재 i의 위치는 S나 D나 T가 있는 위치
                    }
                }
                if(curIdx+1 >= dartResult.length()){
                    arr.add(curNumber);
                    break;
                }
                else if(dartResult.charAt(curIdx+1) == '*'){
                    // 내 앞에 있는 것 2배
                    if(!arr.isEmpty()) {
                        int tmp = arr.get(arr.size()-1); //전에 꺼 가져오고
                        arr.remove(arr.size()-1); //삭제 하고
                        arr.add(tmp*2); //곱해서 다시 집어넣음
                    }
                    // 나도 2배
                    arr.add(curNumber*2);
                    //idx 초기화
                    idx=curIdx+2;
                }
                else if(dartResult.charAt(curIdx+1) == '#'){
                    //나만 -
                    arr.add(curNumber*(-1));
                    idx=curIdx+2;
                }
                else{//뒤에 문자나 숫자
                    arr.add(curNumber);
                    idx = curIdx+1;
                }
            }

            //결과 출력하기
            for(int i : arr){
                answer += i;
            }

            return answer;
    }
}