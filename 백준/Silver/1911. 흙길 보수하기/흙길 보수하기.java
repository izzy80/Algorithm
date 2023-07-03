import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	/*
	 * 입력
	 * 1줄 : N(웅덩이의 수), L(널빤지들의 길이)
	 * 2줄~ : 각각의 웅덩이들의 정보 
	 * 시작 위치와 끝 위치 
	 * 
	 * 출력
	 * 첫째 줄에 모든 물웅덩이들을 덮기 위해 필요한 널빤지들의 최소 개수 
	 */
	public static class Pond implements Comparable<Pond>{
		int st;
		int ed;
		
		public Pond(int st, int ed) {
			this.st = st;
			this.ed = ed;
		}

		@Override
		public int compareTo(Pond o) {
			return this.st - o.ed;
		}
	}
	static int N,L;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		ArrayList<Pond> pond = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			int stt = sc.nextInt();
			int edd = sc.nextInt();
			
			pond.add(new Pond(stt, edd));
		}
		
		//청렬 
		Collections.sort(pond);
		int result = 0; 
		int now = 0; 
		for(int i=0;i<pond.size();i++) {
			Pond p = pond.get(i);
			int st = p.st;
			int ed = p.ed;
			for(int j=st;j<ed;j++) {
				if(now < j) {
					result++;
					now = j+L-1;
				}
			}
		}
		System.out.println(result);
		
	}//main
}