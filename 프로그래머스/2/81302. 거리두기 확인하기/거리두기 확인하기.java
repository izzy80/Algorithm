import java.util.*;
class Solution {
    static int[] mover = {-1,1,0,0};
    static int[] movec = {0,0,-1,1};
    
    public int[] solution(String[][] places) {
          int[] answer = new int[5];

            int N = 5;

            for(int i=0; i< N; i++){
                char[][] room = new char[N][N];
                
                for(int j=0; j< N; j++){
                    for(int k = 0; k < N; k++){
                        char c = places[i][j].charAt(k);
                        room[j][k] = c;
                    }
                }
                //거리두기를 제대로 했는지 체크해서 answer에 집어넣어주기
                boolean flag = false;
                for(int j=0; j< 5; j++){
                    for(int k=0; k< 5; k++){
                        if(room[j][k] == 'P'){
                            //주변 탐색
                            if(BFS(j,k, room)){//거리 못 지키면
                                flag = true;
                            }
                        }
                    }
                }
                answer[i] = flag == true? 0: 1;
            }
            return answer;
    }
   private boolean BFS(int r, int c, char[][] room) {
            Queue<int[]> q = new LinkedList<>();
            boolean[][] visited = new boolean[5][5];

            q.add(new int[]{r,c});
            visited[r][c] = true;

            while(!q.isEmpty()){
                int[] current = q.poll();

                for(int m=0; m < 4; m++){
                    int nr = current[0] +mover[m];
                    int nc = current[1] + movec[m];
                    int manhattan = Math.abs(r-nr)+Math.abs(c-nc);

                    if(nr <0 || nr >= 5|| nc < 0 || nc >= 5) continue;
                    if(visited[nr][nc] || manhattan > 2) continue; 
                    if(room[nr][nc] == 'P') return true; //P면 바로 P return
                    else if(room[nr][nc] == 'O'){
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            return false;
        }
}