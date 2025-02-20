import java.util.*;
import java.io.*;

/**
 * 행운이 티켓을 가진 사람들에게 상품을 줌
 * 2N자리 -> 무조건 짝수
 * 왼쪽 N자리의 합 == 오른쪽 N 자리의 합
 *
 * 숌이 티켓 번호 조작하려고 하는데
 * 문자열이 주어질때
 * 연속된 부분 문자열 중 행운의 티켓 규칙을 만족하는 최대 부분 문자열의 길이는?
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ticket = br.readLine();

        int answer = 0;
        for(int i=1; i <= ticket.length()/2; i++){
            int N = i*2;
            for(int j=0; j < ticket.length()-N+1; j++){
                String tmp = ticket.substring(j, j+N);

                int leftSum = numberSum(tmp.substring(0,N/2));
                int rightSum = numberSum(tmp.substring(N/2,N));

                if(leftSum == rightSum){
                    answer = N;
                }
            }
        }

        System.out.println(answer);
    }

    public static int numberSum(String number){
        int sum = 0;
        for(int i=0; i < number.length(); i++){
            sum += number.charAt(i)-'0';
        }

        return sum;
    }
}