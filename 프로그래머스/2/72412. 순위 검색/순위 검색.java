import java.util.*;

class Solution {
    static HashMap<String, ArrayList<Integer>> hm;
    public int[] solution(String[] info, String[] query) {
        //1. hashMap 사용
            // key : info의 모든 경우의 수, value : score
            hm = new HashMap<>();
            for(int i=0; i < info.length; i++){
                String[] str = info[i].split(" ");
                makeInfos(str,"",0);
            }

            //2. hashmap score기준 정렬하기
            for(String key : hm.keySet()){
                Collections.sort(hm.get(key));
            }

            //3. score 이분탐색으로 찾아서 개수 세기
            int[] answer = new int[query.length];
            for(int i=0; i < query.length; i++){
                answer[i] = Binarysearch(query[i]);
            }

            return answer;
    }
    private int Binarysearch(String s) {
            s = s.replaceAll("and","");
            s = s.replaceAll("\\s+"," ");
            String[] tmp = s.split(" ");
//            System.out.println(Arrays.toString(tmp));
            int score = Integer.parseInt(tmp[4]); //찾아야할 점수
            String findKey = tmp[0]+tmp[1]+tmp[2]+tmp[3];

            if(!hm.containsKey(findKey)) return 0;

            ArrayList<Integer> list = hm.get(findKey);

            int start =0;
            int end = list.size()-1;

            while(start <= end){
                int mid = (start+end)/2;
                if(list.get(mid) >= score){
                    end = mid-1;
                }else{
                    start = mid+1;
                }

            }

            return list.size() - start;
        }

        private void makeInfos(String[] info,String str, int depth) {
            if(depth == 4){
                //depth가 4면 완성
                int score = Integer.parseInt(info[depth]);
                if(hm.containsKey(str)){
                    hm.get(str).add(score);
                }
                else{
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(score);
                    hm.put(str,list);
                }
                return;
            }

            makeInfos(info, str+"-",depth+1);
            makeInfos(info, str+info[depth],depth+1);

        }
}