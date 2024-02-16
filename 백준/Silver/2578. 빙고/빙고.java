import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int N = 5;
    static int[] r = new int[N];
    static int[] c = new int[N];
    static int[][] bingo;
    static int left,right; //왼쪽시작 대각선, 오른쪽시작대각선
    static int letBingo;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bingo = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt =0;
        int answer = 0;
        left = 0;
        right = 0;
        letBingo = 0;
        outer : for(int i=0; i <N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int num = Integer.parseInt(st.nextToken()); //사회자가 불러주는 숫자
                cnt++; //몇 번째 숫자인지

                //빙고인지 확인
                if(Check(num)){//빙고 적어도 5개는 불러야 빙고
                    answer = cnt;
                    break outer;
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean Check(int num) { //사회자가 부른 숫자
        for(int i=0; i< N; i++){ //빙고를 돌아
            for(int j=0; j< N; j++){
                if(num == bingo[i][j]){
                    r[i]++;
                    c[j]++;
                    if(i == j) left++;
                    if(i+j == 4) right++;
                }
            }
        }

        if(left == 5) {
            letBingo++;
            left =0;
        }
        if(right == 5){
            letBingo++;
            right = 0;
        }

        for(int i=0; i< N; i++){
            if(r[i] == 5) {
                letBingo++;
                r[i] = 0;
            }
            if(c[i] == 5) {
                letBingo++;
                c[i] = 0;
            }
        }

        if(letBingo >= 3){
            return true;
        }
        return false;
    }
}