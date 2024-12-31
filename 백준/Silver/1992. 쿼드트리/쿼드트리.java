import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i < N; i++){
            String str = br.readLine();
            for(int j=0; j < N; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        divide_quard(0,N, 0, N, 0);

        //출력
        System.out.println(sb.toString());
    }

    static public void divide_quard(int sr, int er, int sc, int ec, int loc){

        if(check(sr, er, sc, ec)){//만약에 true
            //다 똑같음
            sb.append(map[sr][sc]);
        }
        else{//다름
            int midR = (sr+er)/2;
            int midC = (sc+ec)/2;
            sb.append("(");
            divide_quard(sr, midR, sc, midC,1); //왼쪽 위
            divide_quard(sr, midR, midC, ec,2); //오른쪽 위
            divide_quard(midR, er, sc, midC,3); //왼쪽 아래
            divide_quard(midR, er, midC, ec,4); //오른쪽 아래
            sb.append(")");
        }


    }

    static public boolean check(int sr, int er, int sc, int ec){
        int cur = map[sr][sc];
        for(int i=sr; i<er; i++){
            for(int j=sc; j<ec; j++){
                if(cur != map[i][j]) return false;
            }
        }
        return true;
    }
}