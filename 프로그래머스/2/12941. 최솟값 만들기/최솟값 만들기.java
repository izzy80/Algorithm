import java.util.Arrays;

class Solution
{
    public int solution(int []A, int []B)
    {
       
            int answer = 0;

            //정렬
            Arrays.sort(A);
            Arrays.sort(B);

            //큰 것 * 작은 것
            for(int i =0; i< A.length; i++) {
                answer += A[i] * B[A.length - i - 1];
            }
            return answer;
    }
}