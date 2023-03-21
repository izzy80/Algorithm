import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case =1;test_case<=T;test_case++) {
			// 제한된 칼로리 이하의 조합중에서 가장 맛에 대한 점수가 높은 햄버거의 점수는?
			int n = sc.nextInt(); // 재료에 대한 수
			int l = sc.nextInt(); // 제한된 칼로리
			int[][] map = new int[n][2];
			for(int i=0;i<n;i++) {
				for(int j=0;j<2;j++) {
					map[i][j] = sc.nextInt(); 
				}
			}
			int max = Integer.MIN_VALUE;
			for(int i=0;i<(1<<n);i++) {
				int sum = 0; 
				int happy =0; 
				for(int j=0;j<n;j++) {
					if((i & (1<<j))>0) {
						sum+=map[j][1];
						happy+=map[j][0];
					}
				}
				if(sum<=l) {
					if(max<happy) {
						max = happy;
					}
				}
			}
			
			System.out.println("#"+test_case+" "+max);
		}//for문
		
		
		
		
		
	}//main
}