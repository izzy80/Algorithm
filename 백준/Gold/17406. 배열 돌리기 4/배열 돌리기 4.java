import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M, K;
	static int[][] rotation;
	static int[][] A;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		/*
		 * 배열 A의 최솟값 출력 회전은 시계방향으로 한 칸씩 돌림
		 */
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 행
		M = sc.nextInt(); // 열
		K = sc.nextInt(); // 회전 연산의 개수
		A = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		rotation = new int[K][3];
		for (int i = 0; i < K; i++) {
			rotation[i][0] = sc.nextInt()-1; // r
			rotation[i][1] = sc.nextInt()-1; // c
			rotation[i][2] = sc.nextInt(); // s
		}
		
		perm(0, new int[K], new boolean[K]);
		
		System.out.println(min);

	}

	private static void perm(int cnt, int[] arr, boolean[] visited) {
		if(cnt == K) {
            doRotation(arr);
            return;
        }
        for(int i=0; i<K; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            arr[cnt] = i;
            perm(cnt+1, arr, visited);
            visited[i] = false;
        }
	}

	private static void doRotation(int[] arr) {
		int[][] tmp = copyA();

        for(int k=0; k<K; k++) {
            int r = rotation[arr[k]][0];
            int c = rotation[arr[k]][1];
            int S = rotation[arr[k]][2];

            for(int s=1; s<=S; s++) {
                //위
                int upTmp = tmp[r-s][c+s];
                for(int y = c+s; y > c-s; y--) {
                    tmp[r-s][y] = tmp[r-s][y-1];
                }
                //오른쪽
                int rightTmp = tmp[r+s][c+s];
                for(int x = r+s; x > r-s; x--) {
                    tmp[x][c+s] = tmp[x-1][c+s];
                }
                tmp[r-s+1][c+s] = upTmp;
                //아래
                int leftTmp = tmp[r+s][c-s];
                for(int y = c-s; y < c+s; y++) {
                    tmp[r+s][y] = tmp[r+s][y+1];
                }
                tmp[r+s][c+s-1] = rightTmp;
                //왼쪽
                for(int x = r-s; x < r+s; x++) {
                    tmp[x][c-s] = tmp[x+1][c-s];
                }
                tmp[r+s-1][c-s] = leftTmp;
            }
        }

        sum(tmp);
    }

	private static int[][] copyA() {
		int[][] tmp = new int[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                tmp[i][j] = A[i][j];
            }
        }
        return tmp;
	}

	// 행의 최소값
	private static void sum(int[][] tmp) {
		for(int i=0; i<N; i++) {
            int sum = 0;
            for(int j=0; j<M; j++) {
                sum += tmp[i][j];
            }
            if(min > sum) min = sum;
        }
    }
}