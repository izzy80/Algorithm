

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        
        long count5 = fivePowerN(N) - fivePowerN(N - M) - fivePowerN(M);
        long count2 = twoPowerN(N) - twoPowerN(N - M) - twoPowerN(M);

        System.out.println(Math.min(count5, count2));
    }
    
    // 5의 승수를 구하는 함수
    static long fivePowerN(long num) {
        int count = 0;

        while (num >= 5) {
            count += (num / 5);
            num /= 5;
        }
        return count;
    }

    // 2의 승수를 구하는 함수
    static long twoPowerN(long num) {
        int count = 0;

        while (num >= 2) {
            count += (num / 2);
            num /= 2;
        }
        return count;
    }
}
