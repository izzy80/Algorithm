import java.io.*;
import java.util.StringTokenizer;

public class Main {
    final static int MAX = 100 + 10;
    static boolean[][] graph;
    static boolean[] visited;
    static int N, M, start, end, answer;

    public static void main(String[] args) throws IOException {
        //0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        //1. graph에 연결 정보 채우기
        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX];
        answer = -1;

        int x,y;
        for(int i=0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }


        //2. dfs(재귀함수 호출)
        dfs(start, 0);


        //3. 출력
        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }

    private static void dfs(int idx, int depth) {
        visited[idx] = true;
        if(idx == end){
           answer = depth;
           return;
        }

        for(int i=1; i <=N; i++){
            if(visited[i] == false && graph[idx][i]){
                dfs(i, depth+1);
            }
        }


    }
}