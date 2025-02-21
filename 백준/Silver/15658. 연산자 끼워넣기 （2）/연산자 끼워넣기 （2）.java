import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] op;
    static int[] number;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        number = new int[N];
        for(int i=0; i < N; i++){
            number[i]  = Integer.parseInt(st.nextToken());
        }
        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i < 4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }

        //solve
        cal(number, 0, "");

        System.out.println(max);
        System.out.println(min);
    }

    public static void cal(int[] number, int depth, String oper){
        if(depth == N-1){
            int total = number[0];

            int opIdx = 0;
            int nIdx = 1;
            while(true){
                if(opIdx >= oper.length()) break;
                int o = oper.charAt(opIdx)-'0';
                switch (o){
                    case 0:
                        total = total + number[nIdx];
                        break;
                    case 1:
                        total = total - number[nIdx];
                        break;
                    case 2:
                        total = total * number[nIdx];
                        break;
                    case 3:
                        total = total / number[nIdx];
                        break;
                }

                opIdx++;
                nIdx++;
            }

            min = Math.min(min, total);
            max = Math.max(max, total);
            return;
        }

        for(int i=0; i < 4; i++){
            if(op[i] > 0){
                op[i]--;
                cal(number, depth+1, oper+i);
                op[i]++;
            }
        }

    }
}