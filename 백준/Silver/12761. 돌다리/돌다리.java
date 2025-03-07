import java.io.*;
import java.util.*;

public class Main { // 돌다리
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int A=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken()); // 출발
		int M=Integer.parseInt(st.nextToken()); // 도착
		
		boolean visited[]=new boolean[100001];
		int answer[]=new int[100001];
		Queue<Integer>queue=new LinkedList<>();
		queue.add(N);
		visited[N]=true;
		
		while(!queue.isEmpty()) {
			int temp=queue.poll();
			int arr[]={temp-1,temp+1, temp-A,temp+ A, temp-B, temp+B, temp*A, temp*B};
			for(int i=0; i<8; i++) {
				if(arr[i]>=0 && arr[i]<=100000 && !visited[arr[i]]) {
					visited[arr[i]]=true;
					answer[arr[i]]=answer[temp]+1;
					queue.add(arr[i]);
				}
			}
			if(answer[M]>0)break;
		}
		System.out.println(answer[M]);
	}
}