import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
         int cnt = 0;
	        
	        Arrays.sort(people); // 정렬 
	        
	        int start = 0; 
	        int end = people.length-1;
	        
	        while(start <= end) {
	        	if(people[start]+people[end] <= limit) {
	        		start += 1;
	        		end -=1; 
	        	}
	        	else {
	        		end-=1;
	        	}
	        	cnt++; 
	        }
	        return cnt;
    }
}