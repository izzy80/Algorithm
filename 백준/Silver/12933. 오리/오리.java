import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final char[] QUACK = {'q','u','a','c','k'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        //들어온 문자열이 5로 나누어 떨어지지 않으면 올바른 오리의 수가 아님
        if(arr.length % 5 != 0){
            System.out.println(-1);
            return;
        }

        //solve
        int remain = arr.length;
        int cnt =0;
        while(remain != 0){
            int pt = 0;
            int idx = 0;
            boolean check = false;
            int[] tmp = new int[5];
            while(idx < arr.length){ //한 바퀴 다 돌때까지
                if(arr[idx] == QUACK[pt]){
                    tmp[pt++] = idx;
                    if(pt == 5){
                        check = true;
                        remain -= 5;
                        pt = 0;
                        for(int i=0; i < 5; i++) {
                            arr[tmp[i]] = '\0';
                        }
                    }
                }
                idx++;
            }
            if(check) cnt++;
            else break; //한 바퀴 다 돌았는데도 남아있으면
        }
        //출력
        System.out.println(remain==0?cnt:-1);
    }
}