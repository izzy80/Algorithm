import java.util.*;

class Solution {
    static int n,m;
    static int sum;
    static int[][] oil; //석유 덩어리의 id를 저장 
    static boolean[][] visited;
    static int[] mover = new int[] {-1,0,1,0};
    static int[] movec = new int[] {0,1,0,-1};

    public int solution(int[][] land) {
            n = land.length; //행 가로
            m = land[0].length; //열 세로 
            oil = new int[n][m];
            visited = new boolean[n][m];

            //1. 전체 배열을 돌면서 id당 덩어리 크기 저장 
            int oilId = 0; //석유 덩어리 id
            Map<Integer, Integer> oilSize = new HashMap<>(); //석유 덩어리 크기 저장
            for(int i=0; i<n;i++) {
                for(int j=0; j<m;j++) {
                    if(land[i][j] == 1 && !visited[i][j]) {
                        int size = BFS(land, i,j, oilId);
                        oilSize.put(oilId, size);
                        oilId++;
                    }
                }
            }

            //현재 oil배열에는 oilId로 영역이 구분되어 있음 
            int[] oilSum = new int[m]; //각 열에서 나올 수 있는 석유의 총량
            for(int j=0;j<m;j++) {//열을 for문으로 돌음
                Set<Integer> oilSet = new HashSet<>();
                 for (int i = 0; i < n; i++) {  
                     if (land[i][j] == 1) {  
                         oilSet.add(oil[i][j]);  
                     }  
                 }  
                
                //land가 1인 곳은 석유가 나오는 곳. oil배열에는 oilI로 구분되어 있고
                //set으로 중복 제거 
                //어떤 id가 있는지 뽑아서 영역 계산함. 
                 for (int id : oilSet) {  
                     oilSum[j] += oilSize.get(id);  
                 }  
            }
            //정렬함
            Arrays.sort(oilSum);

            //가장 석유량이 많은 것을 추출 
            return oilSum[m-1];
    }
    public static int BFS(int[][] land, int r, int c, int oilId) {
        int sum = 0; 

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r,c});
        visited[r][c] = true;
        oil[r][c] = oilId;  

        while(!q.isEmpty()) {
            int[] tmp = q.poll(); 
            int cr = tmp[0];
            int cc = tmp[1];
            sum++;

            for(int v=0; v< 4; v++) {
                int nr = cr+mover[v];
                int nc = cc+movec[v];

                if(nr <0 || nr >= n || nc <0 || nc >= m) continue;
                if(visited[nr][nc] || land[nr][nc] == 0) continue;
                q.add(new int[] {nr,nc});
                visited[nr][nc] = true;
                oil[nr][nc] = oilId;  
            }

        }

        return sum;
    }
}