import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Point[] point = new Point[3];

		for (int i = 0; i < 3; i++) {
			String str = sc.nextLine();
			int x = Integer.parseInt(str.split(" ")[0]);
			int y = Integer.parseInt(str.split(" ")[1]);

			point[i] = new Point(x, y);
		}
		//출력 
		System.out.println(ccw(point));

	}

	private static int ccw(Point[] p) {
		// CCW 공식 (x1y2+x2y3+x3y1)−(y1x2+y2x3+y3x1)
		int result = ((p[0].x * p[1].y) + (p[1].x * p[2].y) + (p[2].x * p[0].y))
				- ((p[0].y * p[1].x) + (p[1].y * p[2].x) + (p[2].y * p[0].x));
		if (result > 0)
			return 1;
		else if (result == 0)
			return 0;
		else
			return -1;
	}
}