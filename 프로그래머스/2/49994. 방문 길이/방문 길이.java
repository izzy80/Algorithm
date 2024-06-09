import java.util.*;

class Solution {
    static int[] mover = {-1,0,1,0}; 
    static int[] movec = {0,-1,0,1}; 
    
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] visited = new boolean[11][11][4];
        
        int r = 5;
        int c = 5; 
        for(int i=0; i < dirs.length(); i++){
            int dir = 0; 
            char tmp = dirs.charAt(i); 
            
            if(tmp == 'U'){
                dir = 0; 
            }
            else if(tmp == 'L'){
                dir = 1; 
            }
            else if(tmp == 'D'){
                dir = 2; 
            }
            else{
                dir = 3; 
            }
            int nr = r + mover[dir];
            int nc = c + movec[dir];
            if(nr < 0 || nr >= 11 || nc < 0 || nc >= 11) continue;
            if(!visited[nr][nc][dir]){ //방문하지 않았다면
                visited[nr][nc][dir] = true; 
                dir = (dir%2 == 0)? 2-dir:4-dir; //왕복도 제거하기 위해 
                visited[r][c][dir] = true; 
                answer++;
                
            }
            r = nr;
            c = nc;
           
        }
        
        return answer;
    }
}