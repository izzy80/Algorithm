import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int i=1;
		int cnt =0; 
		int flag = 0; 
		while(i<=1000000) {
			String stm = Integer.toString(i);
			int sum =0;
			for(int j=0;j<stm.length();j++) {
				sum+=stm.charAt(j)-'0';
			}
			sum+=i;
			if(sum==n) {
				System.out.println(i);
				break;
			}
			else {
				cnt++;
			}
			if(cnt==1000000) {
				flag = 1;
			}
			i++;
		}
		if(flag ==1) {
			System.out.println(0);
		}
	}

}