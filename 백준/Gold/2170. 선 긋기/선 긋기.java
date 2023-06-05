import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import javax.sound.sampled.Line;

public class Main {
	static class Line implements Comparable<Line>{
		int x;
		int y;
		
		public Line(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Line l) {
			int rs = this.x - l.x;
			if(rs == 0) rs = this.y - l.y;
			return rs;
		}
		
		
	}
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		ArrayList<Line> list = new ArrayList<Line>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Line(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list);
		int ans = list.get(0).y - list.get(0).x;
		int prev = list.get(0).y;
		for(Line line : list) {
			if(prev >= line.y) {
			
			}else if(prev < line.y &&prev>line.x) {
				ans += line.y - prev;
				prev = line.y;
			}
			else {
				ans += line.y - line.x;
				prev = line.y;
			}
		}
		System.out.println(ans);
	}
}