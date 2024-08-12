import java.io.*;
import java.util.*;

public class Main {
    // 만들 수 있는 식의 결과가 최대와 최소인 것을 구하여라
    static int max;
    static int min;
    static int N; // 숫자의 개수
    static int[] numbers; // 식에 사용되는 숫자
    static int[] op; // 식에 사용되는 연산자
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for(int i=0;i<N;i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        op = new int[4];
        for(int i=0;i<4;i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        dfs(numbers[0],1);

        System.out.println(max);
        System.out.println(min);
    }
    private static void dfs(int num, int idx) {
        if(idx==N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for(int i=0;i<4;i++) {
            if(op[i]>0) { // 연산자의 개수가 1 이상이면

                op[i]--; // 연산자를 1개 감소

                switch(i) {

                    case 0: // i = 0 : +
                        dfs(num+numbers[idx], idx+1); break;

                    case 1: // i = 1 : -
                        dfs(num-numbers[idx], idx+1); break;

                    case 2:	// i = 2 : *
                        dfs(num*numbers[idx], idx+1); break;

                    case 3: // i = 3 : /
                        dfs(num/numbers[idx], idx+1); break;
                }

                // 재귀호출이 종료되면 다시 해당 연산자 개수를 복구
                op[i]++;

            } // if문


        } // for문

    }// main문
}