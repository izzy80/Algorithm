import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		// 땅의 높이는 256을 초과할 수 없고, 음수가 될 수 없다. 
		
		int n = Integer.parseInt(st.nextToken()); // 행
		int m = Integer.parseInt(st.nextToken());// 열
		int b = Integer.parseInt(st.nextToken()); // 블록 개수 
		int[][] map = new int[n][m];
        int total = b;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
            }
        }
		int height = (total) / (n*m);
		if(height > 256) height = 256;
		int min_time = Integer.MAX_VALUE;
		int final_height = height;
		
		 while (height >= 0) {
	            int currentTime = 0;
	            // 현재 높이에서의 시간 구하기
	            for (int i = 0; i < n; i++) {
	                for (int j = 0; j < m; j++) {
	                    if (map[i][j] <= height)
	                        currentTime += (height - map[i][j]);
	                    else
	                        currentTime += (2 * (map[i][j] - height));
	                }
	            }
	            if (currentTime < min_time) {
	                min_time = currentTime;
	                final_height = height;
	            }
	            height--;
	 
	        }
		// 결과 출력 : 시간, 땅의 높이 
		System.out.println(min_time+" "+final_height);
		
	}
}