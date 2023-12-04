import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static boolean[] visited; 

    public int solution(int n, int[][] computers) {
         int answer = 0;
	        visited = new boolean[n];
	        
	        for(int i=0; i<n ; i++) {
	        	for(int j=0; j < n;j++) {
	        		if(!visited[i]) {
	        			BFS(i,computers,n);
	        			answer++;
	        		}
	        	}
	        }
	        return answer;
    }
    
    
    public static void BFS(int i, int[][] computers,int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		visited[i] = true;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();

			
			for(int j =0 ; j <n ;j ++) {	
				if(computers[tmp][j] == 1 && !visited[j]) {
                   q.add(j);
				visited[j] = true; 
                }
				
			}
		}
		
	}
}