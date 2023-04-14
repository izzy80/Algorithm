import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    String str = sc.next();
	    String[] arr = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	    HashMap<String, Integer> hm = new HashMap<>();
	    int idx=1;
	    for(int i=0;i<26;i++) {
	        hm.put(arr[i], idx++);
	    }
	    
	    long answer = 0;
	    for(int i=0;i<str.length();i++) {
	    	answer+=hm.get(String.valueOf(str.charAt(i)))*Math.pow(31, i);
	    }
	    System.out.println(answer);
	   
	}
}