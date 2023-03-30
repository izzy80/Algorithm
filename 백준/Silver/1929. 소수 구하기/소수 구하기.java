import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[1000001];
		
		for(int i=2;i<arr.length;i++) {
			int j=2;
			while(true) {
				if(i*j>1000000) 
					break;
				arr[i*j]=1;
				j++;
			}
		}
		arr[1]=1; // 1은 소수가 아님
		
		int a = sc.nextInt();
		int b = sc.nextInt(); 
		for(int i=a;i<=b;i++) {
			if(arr[i]==0) {
				System.out.println(i);
			}
		}
		
	}

}