import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F,S,G,U,D;
    static int[] floor;

    static int[] move;

    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken()); //회사 층수
        S = Integer.parseInt(st.nextToken()); //강호의 위치
        G = Integer.parseInt(st.nextToken()); //스타트링크의 위치
        U = Integer.parseInt(st.nextToken()); //위로 U층 가는 버튼
        D = Integer.parseInt(st.nextToken()); //아래로 D층 가는 버튼

        floor = new int[F+1]; //F층 까지 존재하니까
        dist = new int[F+1];
        Arrays.fill(dist, -1);

        move = new int[]{U,D};
//        System.out.println(Arrays.toString(move));

        BFS(S);


    }

    private static void BFS(int s) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        dist[s] = 0;


        while(!q.isEmpty()){
            int c = q.poll();
//            System.out.println(c);


            for(int i=0; i< 2; i++){
                int n = 0;
                if(i==0) {
                    n = c + move[i];
                }
                if(i==1){
                    n = c-move[i];
                }
                if(c == G){
                    System.out.println(dist[c]);
                    return;
                }
                if(n <1 || n>F) continue;
                if(dist[n] >= 0) continue;
                dist[n] = dist[c]+1;
                q.add(n);
            }
        }
        System.out.println("use the stairs");
    }
}