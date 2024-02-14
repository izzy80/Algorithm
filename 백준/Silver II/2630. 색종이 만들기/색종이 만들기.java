import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, blue, white;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        StringTokenizer st;
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(N, 0,0);
        System.out.println(white+"\n"+blue);
    }

    private static void solve(int size, int r, int c) {
        if(check(size, r, c)){//true가 나오면
            int whiteBlue = map[r][c];
            if(whiteBlue == 1) blue++;
            else white++;
            return;
        }
        int newSize = size/2;
        solve(newSize, r,c); //왼쪽 위
        solve(newSize, r,c+newSize); //오른쪽 위
        solve(newSize, r+newSize,c); //왼쪽 아래
        solve(newSize, r+newSize,c+newSize); //오른쪽 아래
    }

    private static boolean check(int size, int r, int c) {
        //파란색 흰색 체크
        int first = map[r][c];
        for(int i = r; i < r+size; i++){
            for(int j = c; j < c+size; j++){
                if(first != map[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}