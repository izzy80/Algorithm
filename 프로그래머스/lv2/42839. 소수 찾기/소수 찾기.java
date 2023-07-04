import java.util.HashSet;
import java.util.Iterator;

class Solution {
	//중복된 숫자를 제거해주기 위해서 
	HashSet<Integer> numberset = new HashSet<>();
	
	//소수인지 아닌지  판별하는 함수 
	public boolean isPrime(int num) {
		if(num == 0 || num == 1) {
			//0과 1은 소수가 아니다. 
			return false;
		}
		
		//에라토스테네스의 체 
		for(int i=2; i<= Math.sqrt(num);i++) {
			if(num % i == 0) {
				//나누어 진다면 소수가 아니다. 
				return false;
			}
		}
		//위의 조건들에 해당하지 않는다면 소수임. 
		return true; 
	}
	
	//재귀를 이용한 조합 메서드 
	public void recursive(String tmp, String n) {
		//1. 현재 조합을 set에 추가함 
		if(!tmp.equals("")) {
			//비어있지 않다면 numberset에 추가 
			numberset.add(Integer.parseInt(tmp));
		}
		//나머지 숫자를 더해 조합 만들기 
		for(int i=0;i<n.length();i++) {
			//재귀 호출 
			recursive(tmp+n.charAt(i), n.substring(0,i)+n.substring(i+1));
		}
	}
	
	
    public int solution(String numbers) {
        // 조합을 만든다. 
    	recursive("",numbers);
    	
    	//소수의 개수만 센다 
    	int cnt =0; 
    	Iterator<Integer> it = numberset.iterator();
    	while(it.hasNext()) {
    		int number = it.next();
    		if(isPrime(number)) {
    			cnt++;
    		}
    	}
    	return cnt;
    }
    

}