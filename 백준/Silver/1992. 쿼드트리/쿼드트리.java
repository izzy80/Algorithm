

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i=0; i < N; i++){
            String str = br.readLine();
            for(int j=0; j < N; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        //solve
        dfs(0,0,N);

        //print
        System.out.println(sb.toString());
    }

    public static void dfs(int r, int c, int size){
        if(size == 1){
            sb.append(map[r][c]);
            return;
        }
        if(checkNumber(r,c,size, map[r][c])){
            //같다면
            sb.append(map[r][c]);
//            System.out.println("현재 사이즈에서 다 같음");
        }
        else{
            //다르다면
//            System.out.println("현재 사이즈에서 다름");
            int new_size = size/2;
            sb.append("(");
            dfs(r,c,new_size); //
            dfs(r,c+new_size,new_size); //
            dfs(r+new_size,c,new_size); //
            dfs(r+new_size,c+new_size,new_size); //
            sb.append(")");
        }
    }

    public static boolean checkNumber(int startr, int startc, int size, int number){
        for(int r = startr; r < startr+size; r++){
            for(int c = startc; c < startc+size; c++){
                if(map[r][c] != number) return false;
            }
        }
        return true;
    }
}
