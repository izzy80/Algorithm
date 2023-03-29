import java.util.Scanner;

public class Solution {
	static int[] p;
	static StringBuilder sb;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			int n = sc.nextInt();
			int m =sc.nextInt();

			
			// 부모 노드 초기화
			p = new int[n+1];
			for(int i=1;i<n+1;i++) {
				p[i] = i; 
			}
			
			sb = new StringBuilder();
			for(int i=0;i<m;i++) {
				int u = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				if(u==1) {//같은 집합인지 연산
					if(findset(a)==findset(b)) {// 같은 집합이면
						sb.append(1);
					}
					else {//같은 집합이 아니면
						sb.append(0);
					}
				}
				else { // 합집합 연산 
					union(a,b);
				}

			}
			System.out.println("#"+test_case+" "+sb.toString());
		}
		sc.close();
	}
	static int findset(int x) {
		if(x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}
	
	static public void union(int a, int b) {
		p[findset(b)] = findset(a);
	}
	
}