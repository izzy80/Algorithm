import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int BN = 18; 
	static int N = 9; 
	// 규영이 배열
	static int[] gyu = new int[N];
	// 인영이 배열
	static int[] In = new int[N];
	// 순열에 이용
	static boolean[] visit; // 해당 원소 사용 유무
	static int[] result; // 순열결과 저장 
	
	//승부 결과

	static int win =0; 
	static int lose = 0; 
	public static void main(String[] args) {
		// 조합 => 순열
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case =1; test_case <= T; test_case++) {
			// 모든 배열
			int[] all = new int[BN+1];

			// 1. 규영이가 내는 카드 배열 생성
			for(int i=0; i< N;i++) {
				int tmp = sc.nextInt();
				gyu[i] = tmp;
				all[tmp]++;
			}
			//System.out.println(Arrays.toString(gyu));
			
			// 2. 인영이가 내는 카드 배열 생성
			result = new int[N];
			visit = new boolean[N];
			int index =0;
			for(int i=1;i<all.length;i++) {
				if(all[i]!=1) {
					In[index] = i;
					index++;
				}
			}
			//System.out.println(Arrays.toString(all));
			//System.out.println(Arrays.toString(In));
			
			// 3. 인영이 카드를 이용해서 조합을 해본다. 
			perm(0);
			
			// 출력
			System.out.println("#"+test_case+" "+win+ " "+lose);
			
			// 다음 케이스를 위해 초기화 
			win = 0; 
			lose = 0; 
			

		}// test_case
		
	}// main
	
	private static void perm(int idx) {
		// 인영이의 카드의 순열
		if(idx == N) {
			// 하나의 경우의 수가 result에 생성됨. 
			// 여기서 인영 vs 규영함. 
			int Insum = 0;
			int gyusum = 0; 
			for(int i=0;i<N;i++) {
				if(result[i] > gyu[i]) {
					Insum += result[i]+gyu[i];
				}
				else if(result[i] < gyu[i]) {
					gyusum += result[i]+gyu[i];
				}
			}
			if(Insum > gyusum) {
				lose++;
			}
			else if(Insum < gyusum) {
				win++;
			}
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(visit[i]) continue;
			result[idx] = In[i];
			visit[i] = true;
			perm(idx+1);
			visit[i] = false; 
		}
	}
}