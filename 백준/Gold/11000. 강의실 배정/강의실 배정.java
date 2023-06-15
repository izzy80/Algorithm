import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static class Lecture {
	    int st;
	    int ed;

	    Lecture(int st, int ed) {
	        this.st = st;
	        this.ed = ed;
	    }
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Lecture[] lectures = new Lecture[N];
		
		for(int i=0;i<N;i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			lectures[i] = new Lecture(st, ed);
		}
		
		Arrays.sort(lectures, (l1, l2) -> l1.st == l2.st ? l1.ed - l2.ed : l1.st - l2.st);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lectures[0].ed);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= lectures[i].st) {
                pq.poll();
            }
            pq.offer(lectures[i].ed);
        }
        
        System.out.println(pq.size());
		
	}
}