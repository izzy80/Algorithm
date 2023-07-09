import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
      int l = commands.length;
	    	int[] answer = new int[l];
	    	int n = 0; 
	    	for(int i=0; i< l; i++) {
	    		int st = commands[i][0]-1;
	    		int ed = commands[i][1]-1;
	    		int ll = ed-st+1; 
	    		
	    		int[] tmp = new int[ll];
	    		int num =0; 
	    		for(int j=st;j<=ed;j++) {
	    			tmp[num] = array[j];
	    			num++;
	    		}
	    		Arrays.sort(tmp);
	    		answer[n++] = tmp[commands[i][2]-1];
	    	}
	        return answer;
	    }
    }
