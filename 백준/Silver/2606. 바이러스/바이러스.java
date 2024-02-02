import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
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

        cnt = 0;
        DFS(1);

        System.out.println(cnt-1); //1제외 
    }

    private static void DFS(int idx) {
        visited[idx] = true;
        cnt++;

        //종료
        if(idx == computerCnt+1){
            return;
        }

        //실행
        for(int i=0; i< arr.length; i++){
            if(arr[idx][i] == 0) continue;
            if(visited[i]) continue;
            DFS(i);
        }



    }
}