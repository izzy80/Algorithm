import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		int L = sc.nextInt();
		Queue<Integer> truck = new LinkedList<>();
		for(int i=0;i<N;i++) {
			truck.offer(sc.nextInt());
		}
		Queue<Integer> a = new LinkedList<>();
		for(int i=0;i<W;i++) {
			a.add(0);
		}
		int time =0;
		int bw =0; 
		while(!a.isEmpty()) {
			time++;
			bw-=a.poll();
			if(!truck.isEmpty()) {
				if(truck.peek()+bw<=L) {
					bw+=truck.peek();
					a.offer(truck.poll());
				}
				else {
					a.offer(0);
				}
			}
		}
		System.out.println(time);
	}
}