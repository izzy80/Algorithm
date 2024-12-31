import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[][] map;
    static int w_cnt, b_cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        StringTokenizer st;
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //풀이
        divide_nemo(0,N,0,N);


        //출력
        System.out.println(w_cnt);
        System.out.println(b_cnt);
    }

    static public void divide_nemo(int sr, int er, int sc, int ec){
        if(check(sr,er, sc, ec)){
            //체크했는데 색이 다 똑같
            if(map[sr][sc] == 0){
                w_cnt++;
            }
            else{
                b_cnt++;
            }

        }
        else{//체크했는데 색이 다름
            // 범위를 네 부분으로 나누어 재귀 호출
            int midRow = (sr + er) / 2;
            int midCol = (sc + ec) / 2;

            divide_nemo(sr, midRow, sc, midCol); // 왼쪽 위
            divide_nemo(sr, midRow, midCol, ec); // 오른쪽 위
            divide_nemo(midRow, er, sc, midCol); // 왼쪽 아래
            divide_nemo(midRow, er, midCol, ec); // 오른쪽 아래
        }
    }

    static public boolean check(int sr, int er, int sc, int ec){
        int cur = map[sr][sc];
        for(int i=sr; i < er; i++){
            for(int j=sc; j<ec ; j++){
                if(cur != map[i][j]) return false;
            }
        }
        return true;
    }
}