import java.util.Scanner;

public class swea10726_이진수표현_D3_bit연산자이용 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <=T;test_case++) {
			String answer = "OFF";
			
			int checkBitSize = sc.nextInt();
			int num = sc.nextInt();
			
			int checkBit = (1 << checkBitSize) - 1;
			if((num & checkBit) == checkBit) {
				answer = "ON";
			}
			// 30 -> 2진수로 표현하면 11110.
			// 4개의 비트가 켜져있는지 확인. 
			// 1 << 4 => 10000 여기서 -1을 해주면 1111 4개의 1을 만들어낼 수 있다. 
			// 1 
			// 1번 옮기면 10
			// 더 옮기면 100
			// 더 옮기면 1000
			// 더 옮기면 10000
			
			// 11110
			// 01111 & 연산하면
			// 01110 == 01111 -> 마지막 비트가 다 켜져 있지 않다. 
			
			System.out.println("#"+test_case+" "+answer);
		}
		
	}

}
