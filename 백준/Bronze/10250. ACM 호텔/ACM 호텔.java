import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt(); // tc 개수
		for(int test_case=0;test_case<tc;test_case++) {
			int h = sc.nextInt(); // 높이
			int w = sc.nextInt(); // 너비
			int n = sc.nextInt(); // 사람
			
			int num = 0; 
			int[][] map = new int[h][w];
			for(int j=0;j<w;j++) {
				for(int i=h-1;i>=0;i--) {
					map[i][j] = ++num;
					if(map[i][j] == n) {
						if(j+1<10) {
							System.out.println((h-i)+"0"+(j+1));
						}
						else {
							System.out.println((h-i)+""+(j+1));
						
						}
						
					}
				}
			}
			//System.out.println(Arrays.deepToString(map));
		}
		
	}
}