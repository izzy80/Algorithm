    
class Solution {
    static int[][] map;
    public int[] solution(int rows, int columns, int[][] queries) {
           //1. 맵 만들기
            map = new int[rows][columns];
            int cnt = 1;
            for(int i=0; i< rows ; i++){
                for(int j=0;j <columns ; j++){
                    map[i][j] = cnt++;
                }
            }
//            System.out.println(Arrays.deepToString(map));

            int s = 0;
            int[] ans = new int[queries.length];
            int idx =0;
            while( s <queries.length){
                int x1 = queries[s][0]-1;
                int y1 = queries[s][1]-1;
                int x2 = queries[s][2]-1;
                int y2 = queries[s][3]-1;

                int firnum = map[x1][y2];
                int min = firnum;

                //오른쪽으로 이동
                for(int c=y2-1;c>=y1;c--){
                    min = Math.min(min, map[x1][c]);
                    map[x1][c+1] = map[x1][c];
                }

                //위로 이동
                for(int r=x1+1;r<=x2;r++){
                    min = Math.min(min, map[r][y1]);
                    map[r-1][y1] = map[r][y1];
                }

                //왼쪽으로 이동
                for(int c=y1+1;c<=y2;c++){
                    min = Math.min(min, map[x2][c]);
                    map[x2][c-1] = map[x2][c];
                }

                //아래로 이동
                for(int r=x2-1;r>=x1;r--){
                    min = Math.min(min, map[r][y2]);
                    map[r+1][y2] = map[r][y2];
                }

                map[x1+1][y2] = firnum;
                ans[idx++] = min;
                //queries 증가
                s++;
            }

            return ans;
    }
}