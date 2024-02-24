import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        int N = wallpaper.length;
        int M = wallpaper[0].length(); 
        char[][] map = new char[N][M];
        
        for(int i=0; i< N; i++){
            for(int j=0; j < M; j++){
                map[i][j] = wallpaper[i].charAt(j);
            }
        }
        
        int maxr = Integer.MIN_VALUE; 
        int maxc = Integer.MIN_VALUE; 
        int minr = Integer.MAX_VALUE; 
        int minc = Integer.MAX_VALUE; 
        for(int i=0; i < N; i++){
            for(int j=0; j < M; j++){
                if(map[i][j] == '#'){
                    //System.out.println("i = "+i+", j = "+j);
                    maxr = Math.max(maxr, i);
                    maxc = Math.max(maxc, j);
                    minr = Math.min(minr, i);
                    minc = Math.min(minc, j);
                }
            }
        }
        answer[0] = minr;
        answer[1] = minc;
        answer[2] = maxr+1;
        answer[3] = maxc+1;
        
        return answer;
    }
}