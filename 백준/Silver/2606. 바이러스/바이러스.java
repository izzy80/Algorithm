import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {
    static int[][] arr;
    static boolean[] visited;
    static  int computerCnt;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computerCnt = Integer.parseInt(br.readLine());

        arr = new int[computerCnt+1][computerCnt+1];
        visited = new boolean[computerCnt+1];

        int pairCnt = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i< pairCnt ; i++){
          st = new StringTokenizer(br.readLine());
          int computer1 = Integer.parseInt(st.nextToken());
          int computer2 = Integer.parseInt(st.nextToken());
          arr[computer1][computer2] = 1;
          arr[computer2][computer1] = 1;
        }
//        System.out.println(Arrays.deepToString(arr));

        cnt =0;
        BFS(1);

        System.out.println(cnt);

    }//main

    private static void BFS(int idx) {
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        visited[idx] = true;

        while(!q.isEmpty()){
            int current = q.poll();

            for(int i=0; i< arr.length; i++){
                if(visited[i]) continue; //방문했다면 넘어가
                if(arr[current][i] == 0) continue; //0이면 연결되어있지 않음
                q.add(i);
                visited[i] = true;
                cnt++;
            }
        }


    }
}