
class Solution {
    static int N, maxMinus;
static int[] lion;
static int[] answer = {-1};
        public int[] solution(int n, int[] info) {
            N = n; //화살의 개수
            maxMinus = -1;
            lion = new int[11];
            DFS(info, 0, 0); //완전탐색
            return answer;
        }

        private void DFS(int[] apeach, int idx, int arrowCnt) {
            //idx는 10점~0점, arrowCnt는 사용한 화살의 수
            if (idx == 11) {//idx가 11이면 배열을 다 돌음
                if (arrowCnt == N) {//화살 다 씀
                    int apScore = 0; //어피치 점수
                    int liScore = 0; //라이언 점수

                    //최종점수 계산해주기
                    for (int i = 0; i < 11; i++) {
                        if (apeach[i] == 0 && lion[i] == 0) {
                            //각 점수에서 어피치와 라이언의 화살개수가 0이면 점수 변화x
                            continue;
                        }
                        //만약에 어피치가 라이언보다 점수가 같거나 크면 apScore에 점수 올려줌
                        //lion배열의 index가 0일때는 사실 10점일때이다. 그래서 점수를 10-i를 더해줌
                        if (apeach[i] >= lion[i]) apScore += 10 - i;
                        else liScore += 10 - i;
                    }

                    //최종점수 정산
                    if (liScore > apScore) {//라이언이 어피치를 이김
                        if (liScore - apScore > maxMinus) {
                            //라이언이 가장 큰 차이로 이기는 경우
                            maxMinus = liScore - apScore;
                            answer = lion.clone();
                        }
                        else if (liScore - apScore == maxMinus) {
                            //라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지 일 경우
                            //가장 낮은 점수를 더 많이 맞힌 경우를 return하기 위해 
                            for (int i = 10; i >= 0; i--) {//낮은 점수로 도는데
                                if (answer[i] < lion[i]) {//전 것과 비교해서  현재 것이 더 크면 answer 배열 바꾸기
                                    answer = lion.clone();
                                    return;
                                } else if (answer[i] > lion[i]) return;
                            }
                        }
                    }
                }
                return;
            }

            //둘다 0으로 점수 받기 포기
            if (apeach[idx] == 0) {
                DFS(apeach, idx + 1, arrowCnt);
            }

            //어피치 이기기
            if (arrowCnt + 1 + apeach[idx] <= N) { 
                //현재까지 사용한 화살 수+1에 어피치 화살 수를 더해도 전체 화살 수가 넘지 않으면
                lion[idx] = apeach[idx] + 1;
               DFS(apeach, idx + 1, arrowCnt + 1 + apeach[idx]);
                lion[idx] = 0;
            }

            //어피치한테 지기
            if (apeach[idx] != 0) {
                for (int i = 0; i <= apeach[idx]; i++) {
                    lion[idx] = i;
                    DFS(apeach, idx + 1, arrowCnt + i);
                    lion[idx] = 0;
                }
            }
        }
    }