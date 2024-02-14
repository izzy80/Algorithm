import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        arr = new int[N][N];
        for(int i =0; i < N; i++){
            String str = br.readLine();
            for(int j=0; j < N; j++){
                arr[i][j] =str.charAt(j)-'0';
            }
        }
        sb = new StringBuilder();
        solve(N, 0,0);
        System.out.println(sb.toString());
    }

    private static void solve(int size, int r, int c) {
        if(check(size, r,c)){//모두 같다면
            sb.append(arr[r][c]);
            return;
        }
        //같지 않다면
        sb.append("(");
        int newSize = size/2;
        solve(newSize, r,c);//왼쪽 위
        solve(newSize, r,c+newSize);//오른쪽 위

        solve(newSize, r+newSize,c);//왼쪽 아래
        solve(newSize, r+newSize,c+newSize);//오른쪽 아래
        sb.append(")");

    }

    private static boolean check(int size, int r, int c) {
        int value = arr[r][c]; //처음에는 0, 0이 들어옴
        for(int i=r; i < r+size; i++){
            for(int j= c; j < c+size; j++){
                if(value != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}