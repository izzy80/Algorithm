import java.util.*;
import java.io.*;

/**
 * 세준이가 i번 사람에게 인사하면 L[i]만큼 체력을 잃고, J[i]만큼 기쁨을 얻는다.
 * 각각의 사람에게 최대 1번만 말할 수 있다.
 * 체력은 100이고, 기쁨은 0이다.
 * 체력이 0이나 음수가 되면, 죽어서 아무런 기쁨을 못 느낀 것이 된다.
 * 세준이가 얻을 수 있는 최대 기쁨을 출력해라.
 *
 * N<= 20 -> dfs로 완전탐색 가넝
 *
 */
public class Main {
    static int N;
    static int[] healths;
    static int[] happys;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //사람의 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        healths = new int[N];
        happys = new int[N];
        for(int i=0; i < N; i++){
            healths[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++){
            happys[i] = Integer.parseInt(st.nextToken());
        }

        //solve
        dfs(0,100,0);


        //print
        System.out.println(answer==Integer.MIN_VALUE? 0 : answer);
    }

    public static void dfs(int depth, int health, int happy){
        if(depth == N){
            if(health <=  0) return;
            answer = Math.max(answer, happy);
            return;
        }

        if(health > 0){
            dfs(depth+1, health-healths[depth], happy+happys[depth]);
            dfs(depth+1, health, happy);
        }
    }
}