import java.util.Scanner;

public class Main {
	static int answer = 0; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// r,c를 몇 번째 방문했는가? 
		int N = sc.nextInt();
		int r = sc.nextInt(); // 행
		int c = sc.nextInt(); // 열
		int size = (int)Math.pow(2, N); // 한 변의 길이 
		
		z(r,c,size);
		
		System.out.println(answer);
		
	}

	private static void z(int r, int c, int size) {
		if(size == 1) {
			return; // size가 1이면 행, 열을 1개씩 탐색
		}
		
		if(r<size/2 && c<size/2) {//제 2사분면
			z(r, c, size/2);
		}
		else if(r<size/2 && c>=size/2) {//제 1사분면
			answer+=size*size/4;
			z(r, c-size/2, size/2);
		}
		else if(r>=size/2&& c<size/2) {//제 3사분면
			answer+=(size*size/4)*2;
			z(r-size/2, c, size/2);
		}
		else {//제 4사분면
			answer+=(size*size/4)*3;
			z(r-size/2, c-size/2, size/2);
		}
		
		
	}
}
