//https://jingmong.tistory.com/46
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	public static int[] alpha = new int[26];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		int N = Integer.parseInt(br.readLine());
			
		for(int t = 0; t< N; t++) {
			String line = br.readLine();
			int size = line.length();
			int base = (int)Math.pow(10, size-1);
			
			for(int i=0;i<size;i++) {
				alpha[line.charAt(i)-'A']+=base;
				base/=10;
			}
		}
		
		Arrays.sort(alpha);
		int ans = 0; 
		int num = 9; 
		
		for(int i = 25; i>= 0; i--) {
			ans += alpha[i]*num;
			num--;
		}
		
		System.out.println(ans);
	}//main
}