import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		int[] Acnt = new int[100001];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int l = 0, r = 0;
		int ans = 0;
		while (l <= r) {
			if (r <= N - 1 && Acnt[A[r]] < K) {
				Acnt[A[r]]++;
				r++;

			} else if (Acnt[A[r]] == K) {
				Acnt[A[l]]--;
				l++;
			}

			ans = Math.max(ans, r - l);
			if (r == N)
				break;
		}
		System.out.println(ans);
	}

}