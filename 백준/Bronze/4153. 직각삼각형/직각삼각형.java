import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int[] arr = new int[3];
			for(int i=0;i<3;i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			
			if(arr[0]==0&&arr[1]==0&&arr[2]==0) {
				break;
			}
			else {
				int ap = (int)Math.pow(arr[0], 2);
				int bp = (int)Math.pow(arr[1], 2);
				int cp = (int)Math.pow(arr[2], 2);
				
				if(cp==ap+bp) {
					System.out.println("right");
				}
				else {
					System.out.println("wrong");
				}
				
			}
		}
	}
}