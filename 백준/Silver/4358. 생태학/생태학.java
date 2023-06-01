import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> hm = new HashMap<>();
		double cnt =0; 
		while(sc.hasNextLine()) {
			String set = sc.nextLine();
			if(set.equals("")) {
				break;
			}
			cnt++;
			
			if(hm.isEmpty()) {
				hm.put(set, 1);
			}
			else {
				if(hm.containsKey(set)) {
					hm.put(set, hm.get(set)+1);
				}
				else {
					hm.put(set, 1);
				}
			}
			
		}//while문
		sc.close();
		List<String> keyList = new ArrayList<>(hm.keySet());
        keyList.sort((s1, s2) -> s1.compareTo(s2));
        for (String key : keyList) {
        	double num = (hm.get(key)/cnt)*100;
        	System.out.printf("%s %.4f",key,num);
        	System.out.println();
        }
	}
}