import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int mag_num;
	static int[][] mag;
	static boolean[] rotation_bool;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			// 1. 값 받기
			int K = sc.nextInt();
			mag = new int[4][8];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 8; j++) {
					mag[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < K; i++) {
				mag_num = sc.nextInt(); // 회전시키려는 자석 번호 : 1부터 시작
				int rot = sc.nextInt(); // 회전방향 : 1(시계), -1(반시계)

				// 2-1. 회전 유무 판단하기
				// 회전하기 전에 초기값에서 서로 값이 다르면 회전을 시킴
				// 새로운 자석 번호값이 들어오면 다시 살펴봐주어야 한다.
				// 어차피 기존은 돌려주고, rotation()이 true이면 자석 1번부터 바꿔준다.
				rotation();

				// 2-2. 영향 받은 것 바꿔 주기
				if (mag_num == 1) {
					// 기존 거 돌려주고
					mag[mag_num - 1] = self(mag, mag_num, rot);

					// 나머지도 돌려준다.
					int idx = 0;
					while (idx < 3) {
						int[][] mag_copy = new int[4][8];
						if (rotation_bool[idx] == true) { // 돌려주기
							// 같지 않으면 돌아!!
							rot *= -1;
							for (int j = 0; j < 8; j++) {
								mag_copy[idx + 1][(Math.abs(j + rot)) % 8] = mag[idx + 1][j % 8];
								if (rot == -1) {
									mag_copy[idx + 1][7] = mag[idx + 1][0];
								}
							}
							mag[idx + 1] = mag_copy[idx + 1].clone(); // 원본 바꿔주기
						} else {
							break;
						}
						idx++;
					} // while문
				} else if (mag_num == 2) {
					// 기존 거 돌려주고
					mag[mag_num - 1] = self(mag, mag_num, rot);
					// 나머지도 돌려준다.
					// 왼쪽 방향으로
					int idx = 1;
					int[][] mag_copy = new int[4][8];
					if (rotation_bool[idx - 1] == true) {
						rot *= -1;
						// mag_num-idx-2>=0 // 왼쪽 방향
						for (int j = 0; j < 8; j++) {
							mag_copy[mag_num - 1 - idx][(Math.abs(j + rot)) % 8] = mag[mag_num - 1 - idx][j
									% 8];
							if (rot == -1) {
								mag_copy[mag_num - 1 - idx][7] = mag[mag_num - 1 - idx][0];
							}
						}
						mag[mag_num - 1 - idx] = mag_copy[mag_num - 1 - idx].clone(); // 원본 바꿔주기
					}
					else {
						rot *= -1;
					}
					
					// 오른쪽 방향으로
					int ridx =1; 
					while (idx < 3) {
//						System.out.println("오 = "+rot);
						int[][] mag_copy1 = new int[4][8];
							if (rotation_bool[ridx] == true) {
								for (int j = 0; j < 8; j++) {
									mag_copy1[mag_num - 1 + idx][(Math.abs(j + rot)) % 8] = mag[mag_num - 1 + idx][j
											% 8];
									if (rot == -1) {
										mag_copy1[mag_num - 1 + idx][7] = mag[mag_num - 1 + idx][0];
									}
								}
								mag[mag_num - 1 + idx] = mag_copy1[mag_num - 1 + idx].clone(); // 원본 바꿔주기
							} else {
								break;
							}
							rot *= -1;
							idx++;
							ridx++;
						}// while문
					} 

				else if (mag_num == 3) {
					// 기존 거 돌려주고
					mag[mag_num - 1] = self(mag, mag_num, rot);
					// 나머지도 돌려준다.
					// 오른쪽 방향
					int idx = 1;
					int[][] mag_copy = new int[4][8];
					if (rotation_bool[idx + 1] == true) {
						rot *= -1;
						for (int j = 0; j < 8; j++) {
							mag_copy[mag_num - 1 + idx][(Math.abs(j + rot)) % 8] = mag[mag_num - 1 + idx][j % 8];
							if (rot == -1) {
								mag_copy[mag_num - 1 + idx][7] = mag[mag_num - 1 + idx][0];
							}
						}
						mag[mag_num - 1 + idx] = mag_copy[mag_num - 1 + idx].clone(); // 원본 바꿔주기
					}
					else {
						rot *= -1;
					}
					// 왼쪽 방향
					int ridx =1; 
					while (idx <3) {
						int[][] mag_copy1 = new int[4][8];
						//System.out.println(idx);
						if (rotation_bool[ridx] == true) {
							// mag_num-idx-2>=0 // 왼쪽 방향
							for (int j = 0; j < 8; j++) {
								mag_copy1[mag_num - 1 - idx][(Math.abs(j + rot)) % 8] = mag[mag_num - 1 - idx][j % 8];
								if (rot == -1) {
									mag_copy1[mag_num - 1 - idx][7] = mag[mag_num - 1 - idx][0];
								}
							}
							mag[mag_num - 1 - idx] = mag_copy1[mag_num - 1 - idx].clone(); // 원본 바꿔주기
						} else {
							break;
						}
						rot *= -1;
						idx++;
						ridx--;
					}
				} else if (mag_num == 4) {
					// 기존 거 돌려주고
					mag[mag_num - 1] = self(mag, mag_num, rot);
					// 나머지도 돌려준다.
					int idx = 2;
					int ridx = 2; 
					while (idx <5) {
						int[][] mag_copy = new int[4][8];
						if (rotation_bool[ridx] == true) { // 돌려주기
							// 같지 않으면 돌아!!
							rot *= -1;
							for (int j = 0; j < 8; j++) {
								mag_copy[mag_num - idx][(Math.abs(j + rot)) % 8] = mag[mag_num - idx][j % 8];
								if (rot == -1) {
									mag_copy[mag_num - idx][7] = mag[mag_num - idx][0];
								}
							}
							mag[mag_num - idx] = mag_copy[mag_num - idx].clone(); // 원본 바꿔주기
						} else {
							break;
						}
						ridx--;
						idx++;
					} // while문
				}			
			} // i for문
            
			int sum = 0;// 0번째 위치가 빨간색 화살표의 위치
			if(mag[0][0]==1) {
				sum+=1;
			}
			if(mag[1][0]==1) {
				sum+=2;
			}
			if(mag[2][0]==1) {
				sum+=4;
			}
			if(mag[3][0]==1) {
				sum+=8;
			}

			// 3. 결과 출력
			System.out.println("#" + test_case + " " + sum);
		} // test_case for문

	}// main문

	private static void rotation() {
		rotation_bool = new boolean[3];
		for (int j = 0; j < 4; j++) { // rotation_idx
			if (j + 1 < 4) {
				if (mag[j][2] != mag[j + 1][6]) {
					rotation_bool[j] = true;
				}
			}

		}
	}

	private static int[] self(int[][] mag, int mag_num, int rot) {// 처음 자석은 무조건 회전해주기
		int[][] mag_copy = new int[4][8];
		for (int i = 0; i < 8; i++) {
			mag_copy[mag_num - 1][(Math.abs(i + rot)) % 8] = mag[mag_num - 1][i % 8];
			if (rot == -1) {
				mag_copy[mag_num - 1][7] = mag[mag_num - 1][0];
			}
		}
		return mag_copy[mag_num - 1].clone();
	}
}