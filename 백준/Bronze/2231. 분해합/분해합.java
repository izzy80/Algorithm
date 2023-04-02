import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int i=1;
		int answer=0;
		while(i<=1000000) {
			int sum = 0; 
			sum+=i;
			int j=i;
			while(j>0) {
				sum+=j%10;
				j/=10;
			}
			if(sum == num) {
				answer = i;
				break; 
			}
			i++;
		}
		System.out.println(answer);
	}

}