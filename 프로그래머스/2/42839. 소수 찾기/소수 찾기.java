import java.util.*;

class Solution {
    static HashSet<Integer> hs = new HashSet<>();
        static boolean[] visited;
        public int solution(String numbers) {
            int answer = 0;

            visited = new boolean[numbers.length()];
            DFS(numbers,"",0);
            answer = hs.size();
            return answer;
        }

        public void DFS(String numbers,String tmp, int depth){
            if(depth > numbers.length()){
                return;
            }
            if(!tmp.equals("")){
                int num = Integer.parseInt(tmp);
//                System.out.println(num);
                if(isPrime(num)){
                    hs.add(num);
                }
            }

            for(int i=0; i < numbers.length(); i++){
                if(!visited[i]){
                    visited[i] = true;
                    DFS(numbers,tmp+numbers.charAt(i), depth+1);
                    visited[i] = false;

                }
            }

        }

        public boolean isPrime(int num){
            if(num==1||num==0) return false;
            for(int i=2; i<=Math.sqrt(num); i++){
                if(num%i==0) return false;
            }
            return true;
        }
}