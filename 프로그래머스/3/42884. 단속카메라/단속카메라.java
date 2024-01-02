import java.util.Arrays;
import java.util.Comparator;


class Solution {
    public int solution(int[][] routes) {
         int answer = 0;
	        
	        // 1. 진출 시점 기준으로 오름차순 정렬(이차원배열에서)
	        Arrays.sort(routes, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1] - o2[1];
				}
			});
	      
	     
	        // 2. 하나를 선택하고 진출시점 전에 포함되어 있으면 제외하고 그 다음으로 넘어감. => 반복
	        int first = -30001;
	        
	        for(int i=0; i<routes.length; i++) {
	        	if(first < routes[i][0] ) {
	        		first = routes[i][1];
	        		answer++;
	        	}
	        }
	        return answer;
	    }
}