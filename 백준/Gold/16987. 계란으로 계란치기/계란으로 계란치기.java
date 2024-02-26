import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] s,w;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        s = new int[N];
        w = new int[N];

        StringTokenizer st;
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken()); //내구도
            w[i] = Integer.parseInt(st.nextToken()); //무게
        }

        //dfs
        max = Integer.MIN_VALUE;
        solve(0,  0);

        System.out.println(max);
    }

    private static void solve(int cur,int depth) {
        /**
         * cur : 현재 위치
         * depth : 깨진 계란의 수
         */
        max = Math.max(max, depth);
        if(cur == N) return; //가장 최근에 든 계란이 가장 오른쪽에 위치
        if(s[cur] <= 0) solve(cur+1, depth); //손에 든 계란이 깨진 경우
        else{
            for(int i=0; i< N; i++) {
                if(i == cur || s[i] <= 0) continue; //자기 자신이거나 깨졌으면 선택X
                s[cur] -=w[i];
                s[i] -=w[cur];

                int cnt = depth;
                if(s[i] <= 0) cnt++;
                if(s[cur] <= 0) cnt++;
                solve(cur+1, cnt);

                //복구
                s[cur] +=w[i];
                s[i] +=w[cur];
            }
        }
    }
}