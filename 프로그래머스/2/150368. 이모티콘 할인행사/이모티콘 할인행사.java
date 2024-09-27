import java.util.*;

class Solution {
    static int max= Integer.MIN_VALUE;
    static int min= Integer.MAX_VALUE;
    static int[] discount_arr;
    static int N;
    
    static int[] discount = {10,20,30,40}; 
    
    // 정답
    static int[] answer; 
    static int max_person = 0; 
    static int max_price = 0; 
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        N = emoticons.length; 
        discount_arr = new int[N]; 
        
        for(int i=0; i < users.length; i++){
            max = Math.max(max, users[i][0]);
            min = Math.min(min, users[i][0]);
        }
        
        dfs(users, emoticons, 0);
        
        answer[0] = max_person;
        answer[1] = max_price;
        
        return answer;
    }
    
    public void dfs(int[][] users, int[] emoticons, int depth){
        if(depth == N){
            // System.out.println(Arrays.toString(discount_arr));
            //여기서 계산하기 
            //할인율된 가격
            int[] discount_price = new int[emoticons.length]; 
            for(int i=0; i<N;i++){
                discount_price[i] = emoticons[i]*(100-discount_arr[i])/100;
            }
            
            //users랑 비교
            int[] user_buy = new int[users.length];  
            int person = 0;
            int price = 0; 
            for(int i=0; i < users.length; i++){
                int total_price = 0; 
                for(int j=0; j < emoticons.length; j++){
                    if(users[i][0] <= discount_arr[j]){
                        //만약에 유저의 할인율이 이모티콘의 할인율보다 작으면 유저는 그 이모티콘을 산다. 
                        total_price += discount_price[j];
                    }
                }
                user_buy[i] = total_price;
            }
            //해당 유저가 총 얼마 살 건지 결과 나옴
            for(int i=0; i<users.length; i++){
                if(users[i][1] > user_buy[i]){
                    //이모티콘 살 수 있음
                    price += user_buy[i];
                }
                else{
                    //이모티콘 플러스 가입해야함. 
                    person += 1; 
                }
            }
            
            // 결론
            if(max_person <= person){
                if(max_person == person){
                    max_price = Math.max(max_price, price);
                }
                else{
                    max_price  = price; 
                }
                max_person = Math.max(max_person, person);
            }
            return; 
        }
        
        for(int i=4-1; i >=0; i--){
            discount_arr[depth] = discount[i];
            dfs(users, emoticons, depth+1); 
        }
    
    
    }
}