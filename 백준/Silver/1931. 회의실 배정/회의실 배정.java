import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] meeting = new int[N][2];
		
		StringTokenizer st;
		for(int i =0; i< N; i++) {
			st = new StringTokenizer(br.readLine());
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//1. 회의가 빨리 끝나는 순으로 정렬 (끝나는 시간 기준 오름차순, 끝나는 시간이 같으면 시작하는 것이 빠른 순으로 정렬)
		// => 끝나는 시간이 같으면 시작하는 것이 빠른 순으로 해야하는 이유는 시작하자마자 끝나는 회의가 있기때문이다. 
		Arrays.sort(meeting, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0]-o2[0];
				}
				return o1[1]-o2[1];
			}
		});
		
		//2. 하나를 선택하고 안에 들어가지 않으면 선택 x
		int cur = 0;
		int ans = 0; 
		for(int i=0; i< N;i++) {
			if(cur <= meeting[i][0]) {
				cur = meeting[i][1]; //끝나는 시간
				ans++;
			}
		}
		
		// 3. 정답 출력
		System.out.println(ans);
		

	}

}