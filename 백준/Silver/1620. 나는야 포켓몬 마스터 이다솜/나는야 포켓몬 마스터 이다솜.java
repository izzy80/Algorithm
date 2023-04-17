import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		HashMap<String, Integer> hm = new HashMap<>(); // key, value 
		String[] arr = new String[N];
		int idx =0; 
		for(int i=0;i<N;i++) {
			String s = sc.next();
			hm.put(s, idx++);
			arr[i] = s;
		}
		for(int i=0;i<M;i++) {
			String str = sc.next();
			if(isNumber(str)) {// 숫자일때
				System.out.println(arr[Integer.parseInt(str)-1]);
			}
			else {//영어일때
				System.out.println(hm.get(str)+1);
				
			}
		}
	}
	public static boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
}
