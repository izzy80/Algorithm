/*
단순히 구현으로 풀려고함. 테케는 맞았는데 다른 건 틀렸다고 나옴.
왜? 
반례를 생각해보자. 
처음 구현 로직은 한 행에서 가장 큰 수 선택 -> 그 다음 행에서 가장 큰 수 선택(단 이전에 선택한 값의 열 제외)
이렇게 단순히 구현함. 이 경우
1 2 3 4
4 2 3 100
5 2 1 2
3 2 1 3
이 경우를 고려하지 못 한다. 첫 행에서 4를 선택한 후 100을 선택 못 하게 되는데 그러면 결과적으로 큰 값을 구하지 못함. 그래서 다른 테케가 다 틀렸다고 나오는 것. 
이건 dp로 풀어야함. 
*/
import java.util.*; 
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int N = land.length; 
        int[][] dp = new int[N][4]; 
        
        for (int j = 0; j < 4; j++) {
            dp[0][j] = land[0][j];
        }
        
        for(int i=1; i < N; i++){
            for(int j=0; j < 4; j++){
                int max = Integer.MIN_VALUE; 
                for(int k=0; k < 4; k++){
                    if(k != j){
                        max = Math.max(max, land[i][j]+dp[i-1][k]);
                    
                    }
                }
                dp[i][j] = max; 
            }
        }
        for(int i=0; i < 4; i++){
            answer = Math.max(dp[N-1][i],answer);
        }
        
        return answer;
    }
}