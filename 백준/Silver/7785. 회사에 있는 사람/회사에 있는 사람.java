import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 
		
		HashMap<String, String> hm = new HashMap<>();
		for(int tc=0;tc<T;tc++) {
			hm.put(sc.next(), sc.next()); // 집어넣으면서 중복된 것은 바로 수정해줌 
		}// tc for문
		
		// 정렬
		List<String> key = new ArrayList<>(hm.keySet());
		key.sort(Collections.reverseOrder());
		
		for(String k:key) {
			if(hm.get(k).equals("enter")) {
				System.out.println(k);
			}
		}

	}// main
}