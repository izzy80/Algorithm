import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2 | 1
 * ------
 * 3 | 4
 */
public class Main {
    //-1로만 채워진 종이의 개수
    //0으로만 채워진 종이의 개수
    //1로만 채워진 종이의 개수
    static int mone, zero, one;
    static int arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        StringTokenizer st;
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //재귀
        mone = 0;
        zero = 0;
        one = 0;
        solve(N,0,0);
        StringBuilder sb = new StringBuilder();
        sb.append(mone).append("\n").append(zero).append("\n").append(one).append("\n");
        System.out.println(sb.toString());
    }

    private static void solve(int size,int r, int c) {
        if(check(size, r, c)){
            int standard = arr[r][c];
            if(standard == -1) mone++;
            else if(standard == 0) zero++;
            else one++;
            return;
        }
        //위에 속하지 않는다면
        int newSize = size/3;
        solve(newSize, r,c); //왼쪽 위
        solve(newSize, r,c+newSize); //중앙 위
        solve(newSize, r,c+2*newSize); //오른쪽 위

        solve(newSize, r+newSize,c); //왼쪽 중간
        solve(newSize, r+newSize,c+newSize); //중앙 중간
        solve(newSize, r+newSize,c+2*newSize); //오른쪽 중간

        solve(newSize, r+2*newSize,c); //왼쪽 아래
        solve(newSize, r+2*newSize,c+newSize); //중앙 아래
        solve(newSize, r+2*newSize,c+2*newSize); //오른쪽 아래
    }

    private static boolean check(int size,int r, int c) {
        //1번째 기준으로 검사
        int standard = arr[r][c];
        for(int i=r; i<r+size; i++){
            for(int j=c; j < c + size;j++){
                if(arr[i][j] != standard){
                    return false;
                }
            }
        }
        return true;
    }
}