import java.util.*;

class Solution {
    static final char PERSON = 'P';
    static final char EMPTY = 'O';
    static final char PARTITION = 'X';
    static final int N = 5;
    static int[] mover = {0,0,1,-1};
    static int[] movec = {1,-1,0,0};
    
    public int[] solution(String[][] places) {
         int[] answer = new int[N];

            for(int i=0; i < N; i++){
                int personCnt = 0;
                char[][] map = new char[N][N];
                //map 초기화
                for(int j=0; j < N; j++){
                    for(int k=0; k < N; k++){
                        char c = places[i][j].charAt(k);
                        map[j][k] = c;

                        if(c == PERSON) personCnt++;
                    }
                }
                //solve
                if(personCnt == 0) {
                    answer[i] = 1;
                    continue;
                }
                boolean isSafe = true;
                outer : for(int j = 0; j < N; j++){
                    for(int k=0; k < N; k++){
                        if(map[j][k] == PERSON){
                            if (!bfs(j, k, map)) {
                                isSafe = false;
                                break outer;
                            }
                        }
                    }
                }
                answer[i] = isSafe ? 1 : 0;
            }
            return answer;
    
}

public boolean bfs(int j, int k,char[][] map){
    Queue<int[]> q = new ArrayDeque<>();
    boolean[][] visited = new boolean[N][N];
    q.add(new int[]{j,k});
    visited[j][k] = true;

    while(!q.isEmpty()){
        int[] tmp = q.poll();
        int r = tmp[0];
        int c = tmp[1];

        for(int m =0 ; m <4; m++){
            int nr = r +mover[m];
            int nc = c + movec[m];

            if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            if(visited[nr][nc]) continue;
            if(map[nr][nc] == PARTITION) continue;
            if(Math.abs(j-nr)+Math.abs(k-nc) > 2) continue;
            if(map[nr][nc] == PERSON) return false;
            q.add(new int[]{nr,nc});
            visited[nr][nc] = true;
        }
    }

    return true;
}
}