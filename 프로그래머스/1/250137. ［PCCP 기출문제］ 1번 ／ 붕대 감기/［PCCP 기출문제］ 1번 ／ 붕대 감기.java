class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
          int answer = 0;
	        int len = attacks.length;
	        int time = 0; 
	        int nhealth = health;
	        
	        int conti = 0; //연속 성공 
	        
	        while(time <= attacks[len-1][0]) {//몬스터의 마지막 공격까지
	        	if(nhealth <= 0) {//체력이 0 이하면 -1 return
	        		break;
	        	}
	        	boolean flag = false;
	        	for(int i=0; i< len; i++) {
	        		if(time == attacks[i][0]) {//시간이 몬스터가 공격하는 시간이면
	        			nhealth-=attacks[i][1];
	        			conti = 0; //0으로 초기화
	        			flag = true; //몬스터 공격
	        		}
	        	}
	        	
	        	if(!flag) {//flag가 거짓이면
	        		conti++; //연속 증가
	        		nhealth+=bandage[1]; //1초당 회복량 
	        		if(nhealth > health) {
	        			nhealth = health;
	        		}
	        	}
	        	
	        	if(conti == bandage[0]) {//붕대 감기 기술 시전 시간
	        		conti = 0; 
	        		nhealth+=bandage[2];
	        		if(nhealth > health) {
	        			nhealth = health;
	        		}
	        	}
	        	
	        	time++; //시간 증가
	        }
	        if(nhealth <= 0) {//체력이 0 이하면 -1 return
        		answer = -1;
        	}
	        else {
		        answer = nhealth; 
	        }

	        return answer;
    }
}