class Solution {
    static boolean[] visited;
	static int len;
	static int answer;
    
    public int solution(String begin, String target, String[] words) {
        answer = 0;
	        len = words.length;
	        visited = new boolean[len];
	        int wcnt = 0; 
	        
	        for(int i = 0; i < len; i++) {
	        	if(words[i].equals(target)) {
	        		//words 안에 들어있으면
	        		wcnt++; 
	        	}
	        }
	        
	        if(wcnt != 0) {//words 안에 target이 있다는 것이니까 bfs/dfs 실행 
	        	DFS(begin, target, words, 0);
	        }
	        
	        return answer;
    }
    
    public static void DFS(String now, String target, String[] words, int cnt) {
		if(now.equals(target)) {
			answer = cnt;
			return;
		}
		
		for(int i=0; i<len; i++) {
			if(visited[i]) {//이미 쓴 단어는 skip
				continue;
			}
			
			//두 단어가 몇 글자가 다른지 탐색
			int num = 0; 
			for(int j=0;j<target.length(); j++) {
				if(now.charAt(j)!=words[i].charAt(j)) {
					num++;
				}
			}
			
			//두 단어의 차이가 1개일 때 dfs 실행 
			if(num==1) {
				visited[i] = true;
				DFS(words[i],target, words, cnt+1);
				visited[i] = false;
			}
			
		}//for문
	}
}