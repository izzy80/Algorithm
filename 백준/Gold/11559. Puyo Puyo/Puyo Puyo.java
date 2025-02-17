import java.util.*;
import java.io.*;

/*
. : 빈공간
R : 빨강 / G : 초록 / B : 파랑 / P : 보라 / Y : 노랑
입력으로 주어진 것은 뿌요들이 전부 아래로 떨어진 뒤의 상황
 */
public class Main {
    static final int N = 12;
    static final int M = 6;
    static char[][] map = new char[N][M];
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};
    static Queue<int[]> bumb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i < N; i++){
            String str = br.readLine();
            for(int j=0; j < M; j++){
                map[i][j] = str.charAt(j);
            }
        }
        //solve
        int answer = 0;
        while(true){
            boolean flag = false;
            for(int i=0; i < N; i++){
                for(int j=0; j < M; j++){
                    if(map[i][j] != '.') {//색이 있다면
                        bfs(i, j, map[i][j]);

                        if (bumb.size() >= 4) {
                            while(!bumb.isEmpty()){
                                int[] tmp = bumb.poll();
                                map[tmp[0]][tmp[1]] = '.';
                            }
                            flag = true;
                        }
                    }
                }
            }
            if(!flag) break; //더 이상 터질게 없음
            //내려주기
            moveDown();
            answer++;
        }

        //print
        System.out.println(answer);
    }



    static public void moveDown(){
        //아래로 이동시켜주기

        for(int j = 0; j < M; j++){
            Stack<Character> s = new Stack<>();
            for(int i=0; i < N; i++){
                if(map[i][j] != '.'){
                    //stack에 넣고 초기화 
                    s.push(map[i][j]);
                    map[i][j] = '.';
                }
            }

            if(s.size() != 0){
                for(int i = N-1; i >= 0 ; i--){
                    if(s.isEmpty()) break;
                    char c = s.pop();
                    map[i][j] = c;
                }
            }
        }


    }

    static public void bfs(int r, int c, char color){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        bumb = new ArrayDeque<>();

        q.add(new int[]{r,c});
        bumb.add(new int[]{r,c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int cr = tmp[0];
            int cc = tmp[1];


            for(int m =0; m < 4; m++){
                int nr = cr + mover[m];
                int nc = cc + movec[m];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == color){
                    visited[nr][nc] = true;
                    q.add(new int[]{nr,nc});
                    bumb.add(new int[]{nr,nc});
                }
            }
        }
    }
}