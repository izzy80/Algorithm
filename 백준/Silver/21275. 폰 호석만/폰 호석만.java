import java.math.BigInteger;
import java.util.*;
import java.io.*;

/**
 * X,A,B -> 3개의 숫자 결정
 * X-> 10진법
 * X를 A진법으로 표현한 수. B진법으로 표현한 수
 * 두 개의 수를 통해 원래 숫자인 X,A,B를 계산하자
 * 조건을 만족하는 X,A,B가 여러 개라면 Multiple 출력 가능한 조합이 없으면 Impossible
 *
 * 2~36
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A =st.nextToken();
        String B =st.nextToken();

        int a = 0;
        int b = 0;

        BigInteger number = BigInteger.ZERO;

        int imin = 2;
        int jmin = 2;

        // A의 최소 진법 찾기
        for (char c : A.toCharArray()) {
            int value = (c >= 'a') ? (c - 'a' + 10) : (c - '0');
            imin = Math.max(imin, value + 1);
        }

        // B의 최소 진법 찾기
        for (char c : B.toCharArray()) {
            int value = (c >= 'a') ? (c - 'a' + 10) : (c - '0');
            jmin = Math.max(jmin, value + 1);
        }

        int cnt = 0;
        for(int i=imin; i<=36; i++){
            for(int j=jmin; j <= 36; j++){
                if(i == j) continue;


                // 현재 진법에서 변환할 수 없는 숫자인지 확인
                if (!isValidBase(A, i) || !isValidBase(B, j)) continue;

                BigInteger numA = new BigInteger(A, i);
                BigInteger numB = new BigInteger(B, j);

                if(numA.equals(numB)){
                    a = i;
                    b = j;
                    number = numA;
                    cnt++;
                }
            }
        }

        if(cnt > 1){
            System.out.println("Multiple");
        }
        else if(cnt == 1){
            System.out.println(number +" "+a+" "+b);
        }
        else{
            System.out.println("Impossible");
        }

    }

    private static boolean isValidBase(String num, int base) {
        for (char c : num.toCharArray()) {
            int value = (c >= 'a') ? (c - 'a' + 10) : (c - '0');
            if (value >= base) return false;  // 현재 진법에서 표현 불가능한 숫자가 포함되면 false
        }
        return true;
    }
}