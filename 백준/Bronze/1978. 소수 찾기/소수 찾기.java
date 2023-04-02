import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[10001];
		for(int i=2;i<arr.length;i++) {//2부터 배열
			int j=2;
			while(true) {
				if(i*j>10000) 
					break;
				arr[i*j]=1;
				j++;
			}
		}
		arr[1]=1; // 1은 소수가 아님
		int cnt=0;
		for(int i=0;i<n;i++) {
			int num = sc.nextInt();
			if(arr[num]!=1) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}