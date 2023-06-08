import java.util.Scanner;

public class Main {
	static int max; 
	static int N;
	static char[][] candy;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		candy = new char[N][N];
		max = 0; 
		for(int i=0;i<N;i++) {
			String tmp = sc.next();
			for(int j=0;j<N;j++) {
				candy[i][j] = tmp.charAt(j);
			}
			max = Math.max(max, checkrow(i));
		}
		for(int i = 0; i < N; i++) max = Math.max(max, checkcol(i));
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(j + 1 < N) { 
					swap(i, j, i, j + 1); 
					max = Math.max(max, checkrow(i));
					max = Math.max(max, checkcol(j));
					max = Math.max(max, checkcol(j + 1));
					swap(i, j, i, j + 1); 
				}
				if(i + 1 < N) { 
					swap(i, j, i + 1, j); 
					max = Math.max(max, checkrow(i));
					max = Math.max(max, checkrow(i + 1));
					max = Math.max(max, checkcol(j));
					swap(i, j, i + 1, j);
				}
			}
		}
		System.out.println(max);
	}
	public static void swap(int r1, int c1, int r2, int c2) { 
		char tmp = candy[r1][c1];
		candy[r1][c1] = candy[r2][c2];
		candy[r2][c2] = tmp; 
	}
	public static int checkrow(int r) { // 행 체크
		int tmp = 1, res = 1;
		char ch = candy[r][0];
		for(int i = 1; i < N; i++) {
			if(candy[r][i] != ch) {
				ch = candy[r][i];
				res = Math.max(res, tmp);
				tmp = 1;
			} else tmp++;
		}
		return Math.max(res,  tmp);
	}
	
	public static int checkcol(int c) { // 열 체크
		int tmp = 1, res = 1;
		char ch = candy[0][c];
		for(int i = 1; i < N; i++) {
			if(candy[i][c] != ch) {
				ch = candy[i][c];
				res = Math.max(res, tmp);
				tmp = 1;
			} else tmp++;
		}
		return Math.max(res, tmp);
	}
}