import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 차의 대수 
		String[] Dea1 = new String[N];
		String[] Young1 = new String[N];
		boolean[] checked = new boolean[N];
		
		for(int i=0;i<N;i++) {
			Dea1[i] = sc.next(); 
		}
		for(int i=0;i<N;i++) {
			Young1[i] = sc.next(); 
		}

		int cnt =0; 
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!Dea1[i].equals(Young1[j])) {
					if(checked[j]==false) {
						checked[j] = true;
						cnt++;
					}
				}
				else {//같은 번호이면
					checked[j] = true;
					break;
					
				}
			}
		}
		System.out.println(cnt);
	}
}