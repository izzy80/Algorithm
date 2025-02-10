import java.util.*;
import java.io.*;

/**
 * 인접한 네 칸 중의 한 칸으로 이동 가능
 * (1,1) ->
 * 지금까지 지나온 모든 칸에 적혀있는 알파벳과는 달라야함.
 * 같은 알파벳이 적힌 칸은 두 번 지나칠 수 없다.
 * 말이 최대한 몇 칸을 지날 수 있는 가?
 */

public class Main {
    static int R,C;
    static char[][] map;
    static int[] alpha = new int[26];
    static int answer = 0;
    static boolean[][] visited;
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j= 0; j < C; j++){
                map[i][j] = str.charAt(j);
            }
        }

        //solve
        visited[0][0] = true;
        alpha[map[0][0] -'A']++;
        dfs(0,0,1);

        System.out.println(answer);


    }

    public static void dfs(int r, int c, int cnt){
        if(answer < cnt) answer = cnt;

        for(int m=0; m < 4; m++){
            int nr = r + mover[m];
            int nc = c + movec[m];

            if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if(visited[nr][nc]) continue;
            if(alpha[map[nr][nc]-'A'] != 0) continue;
            
            alpha[map[nr][nc]-'A']++; //알파벳 처리 
            visited[nr][nc] = true; //방문 처리 
            dfs(nr,nc, cnt+1);
            visited[nr][nc] = false; //알파벳 처리 
            alpha[map[nr][nc]-'A']--; //미방문 처리 
        }
    }
}