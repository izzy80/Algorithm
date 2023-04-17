import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String[] sarr = str.split("-"); 
		
		String[] tmp = sarr[0].split("\\+");
		int first = 0;
		for (String t : tmp) {
			first += Integer.parseInt(t);
		}

		int sum = 0;
		for (int i = 1; i < sarr.length; i++) {
			String[] temp = sarr[i].split("\\+");
			for (String t : temp)
				sum += Integer.parseInt(t);
		}
		System.out.println(first - sum);
	}
}