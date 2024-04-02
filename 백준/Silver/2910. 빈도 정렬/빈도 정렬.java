import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
     암호
     N개로 이루어진 수열
     숫자는 모두 <= C
     이 숫자가 등장하는 빈도순서대로 정렬
     X 3, Y 2 이면 암호는 XY
     등장하는 횟수가 같다면 먼저 나온 것이 앞에
      */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        //LinkedHashMap 생성 => 순서 보장
        HashMap<Integer, Integer> hm = new LinkedHashMap<>(); //숫자-빈도
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (hm.containsKey(num)) {// 해시맵 안에 num이 있으면 기존 값에 +1을 해주어 저장
                hm.put(num, hm.get(num) + 1);
            } else {   // 존재하지 않으면 새로 값을 추가
                hm.put(num, 1);
            }
        }

        // 키를 모두 ArrayList에 저장
        List<Integer> list = new ArrayList<>(hm.keySet());

        // ArrayList에 저장된 값 기준 내림차순으로 정렬
        //비교를 위해 Collections 클래스의 sort 메소드 이용
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                //key값을 이용해 value값을 오름차순으로 정렬
                return Integer.compare(hm.get(b), hm.get(a)); 
            }
        });
        

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer element = it.next();
            for (int i = 0; i < hm.get(element); i++) {
                sb.append(element + " ");
            }
        }
        System.out.println(sb);
    }
}