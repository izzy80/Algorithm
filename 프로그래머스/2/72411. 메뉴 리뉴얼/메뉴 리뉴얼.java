import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
 
class Solution {
    static String str;
        static HashMap<String, Integer> menu;
        static boolean isVisited[];
        static int max[];
        public static String[] solution(String[] orders, int[] course) {
            ArrayList<String> answer = new ArrayList<String>();

            max = new int[course.length]; //갯수에 따라 만들 수 있는 경우의 수 중 가장 많이 등장한 개수를 저장하기 위한 max배열
            menu = new HashMap<String, Integer>();
            for (int i = 0; i < orders.length; i++) {
                char a[] = orders[i].toCharArray(); //메뉴 문자열 정렬을 위해 char[] 변환
                Arrays.sort(a); //정렬
                str = String.copyValueOf(a); //정렬된 새로운 문자열 생성

                for (int j = 0; j < course.length; j++) {//코스의 개수별 조합 생성해주기
                    isVisited = new boolean[str.length()]; //정렬된 새로운 문자열을 방문했는지
                    comb(0, 0, "", j, course[j]);
                }
            }

            for (String s : menu.keySet())
                for (int i = 0; i < course.length; i++)
                    if (course[i] == s.length() && max[i] != 1 && menu.get(s) == max[i]) //길이가 같은데 max의 최대랑 같은 경우 추가 
                        answer.add(s);

            return answer.stream().sorted().map(s -> s).toArray(String[]::new);
        }
        private static void comb(int cur, int cnt, String s, int j, int N) {
            /***
             * int cur : 메뉴를 오름차순으로 만들어주기 위해 매개변수로 들고 다님. 사용했던 문자보다 더 뒤에 오는 단어를 사용해야함. 
             * int cnt : depth
             * String s : 새로 생성된 메뉴
             * int j : course의 index
             * int N : course배열에 의한 만들 수 있는 메뉴의 갯수
             */
            if (cnt == N) {
                menu.put(s, menu.getOrDefault(s,0)+1);
                max[j] = Math.max(max[j], menu.get(s)); //조합 중 가장 많이 등장한 메뉴의 갯수를 max에 저장
                return;
            }

            for (int i = cur; i < str.length(); i++) {
                isVisited[i] = true;
                comb(i + 1, cnt + 1, s + str.charAt(i), j, N);
            }
        }
}