import java.util.Scanner;

public class Main {
	final static int MOD = 1000;
	static int N;
	static int[][] matrix;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		//입력 
		N = sc.nextInt();
		long B = sc.nextLong();
		matrix = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				matrix[i][j] = sc.nextInt()%MOD;
			}
		}
		
		int[][] result = pow(matrix, B);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(result[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}//main
	
	//행렬 제곱 분할정복 메소드 
	public static int[][] pow(int[][] A, long exp) {
		//지수가 1일 때 A를 return 
		if(exp == 1L) {
			return A;
		}
		
		//지수를 절반으로 분할하여 재귀 호출
		int[][] ret = pow(A, exp / 2);
		
		//하위 재귀에서 얻은 행렬을 제곱해줌
		ret = multiply(ret, ret);
		
		//만약 지수가 홀수라면 마지막에 A^1 (matrix)를 곱해준다
		if(exp % 2 == 1L) {
			ret = multiply(ret, matrix);
		}
		return ret;
	}

	//o1과 o2 행렬을 곱해주는 메소드 
	public static int[][] multiply(int[][] o1, int[][] o2) {
		int[][] ret = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int k = 0; k<N;k++) {
					ret[i][j] += o1[i][k] * o2[k][j];
					ret[i][j] %= MOD;
				}
			}
		}
		return ret;
	}
	
	
}