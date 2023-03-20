import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T;test_case++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			String str = sc.next();
            // 회전으로 인해 index를 벗어날 수 있으므로 sb에 더해줌
            // n/4는 한 면에 있는 글자수 -1 만큼 회전하기 때문
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<n/4;i++) {
				sb.append(str);
			}
			
			// 회전해서 HashSet에 집어넣음 => 중복 제거
			HashSet<String> hs = new HashSet<>();
			for(int i=0;i<n/4;i++) {
				for(int j=i;j<i+n;j+=(n/4)) {
					hs.add(sb.substring(j, j+(n/4)));
				}
			}
			// System.out.println(hs.toString()); //확인 완
            // 정렬
			String[] arr = hs.toArray(new String[0]);
			int[] narr = new int[arr.length];
			for(int i=0;i<arr.length;i++) {
				narr[i] = Integer.parseInt(arr[i],16);
			}
			Arrays.sort(narr);
			int[] arrn = new int[narr.length];
			int idx = 0; 
			for(int i=narr.length-1;i>=0;i--) {
				arrn[idx] = narr[i];
				idx++;
			}
			//System.out.println(Arrays.toString(narr));
			System.out.println("#"+test_case+" "+arrn[k-1]);
		}
	}
}