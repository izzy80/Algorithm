import java.util.*;
class Solution {
        static Stack<Integer> busket;
    static int answer;
    public int solution(int[][] board, int[] moves) {
         answer = 0;

            //크레인을 동작시켜서 인형을 넣는 곳
            busket = new Stack<>();

            //시작해야 하는 index 위치
            int M = moves.length;
            int BoardLen = board.length;
            int[] startR = new int[BoardLen];
            Arrays.fill(startR, -1); //-1로 초기화
//            System.out.println(M);
            for(int i = 0; i < M; i++){//move별로 돌음
                // System.out.println(Arrays.toString(startR));
                if(startR[moves[i]-1] == -1){//아직 탐색 X
                    for(int r = 0; r < BoardLen; r++){ //정사각형
//                        System.out.println("r = "+ r +" , moves[i]-1 = "+(moves[i]-1));
                        if(board[r][moves[i]-1] == 0){
                            continue;
                        }
                        else{//0이 아니야
                            busketPut(board[r][moves[i]-1]); //Queue에 삽입
                            board[r][moves[i]-1] = 0; //board를 없애줌
                            startR[moves[i]-1] = r+1;  //시작점 갱신
                            break;//한 번 나오면 끝
                        }
                    }
                }
                else if(startR[moves[i]-1] == M){//비어있는 것
                    continue;//비어있으면 이번 move는 하지 않음
                }
                else{//그 위치부터 탐색 시작
                    for(int r = startR[moves[i]-1]; r < BoardLen; r++){ //정사각형
                        busketPut(board[r][moves[i]-1]);
                        board[r][moves[i]-1] = 0;
                        startR[moves[i]-1] = r+1;
                        break; //한 번 나오면 끝
                    }
                }



            }
            return answer;
        }

        private void busketPut(int number) {
            if(busket.isEmpty()){
                //비어 있으면 걍 넣어줌
                busket.add(number);
            }
            else{//안 비어있어
                if(busket.peek() == number){//같으면 소멸
                    answer+=2;
                    busket.pop(); //맨 위 삭제
                }
                else{//안 같아
                    busket.add(number); //안 같으면 그냥 집어넣음
                }
            }
        }
}