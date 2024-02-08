import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
필요한 배추흰지렁이 마리수
 */
public class Main {
    static StringTokenizer st;
    static int M,N,K;
    static boolean[][] map;
    static boolean[][] visited;
    static int[] mover = {-1, 0, 1, 0};
    static int[] movec = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc ++){
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken()); //가로길이 열
            N = Integer.parseInt(st.nextToken()); //세로길이 행
            K = Integer.parseInt(st.nextToken()); //배추가 심어진 위치

            map = new boolean[N][M];
            visited = new boolean[N][M]; //방문배열

            int r, c;

            for(int k = 0;  k < K; k++){
                st = new StringTokenizer(br.readLine());
                c = Integer.parseInt(st.nextToken());
                r = Integer.parseInt(st.nextToken());

                map[r][c] = true; //배추가 심어짐
            }


            int cnt =0;
            for(int i=0; i < N; i++){
                for(int j=0; j <M; j++){
                    if(!visited[i][j] && map[i][j]){//방문하지 않았고, 배추가 존재한다면
                        dfs(i,j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);


        } //tc



    }

    private static void dfs(int r, int c) {
//        System.out.println(r+ ", "+c);
        visited[r][c] = true;

        for(int m =0 ; m< 4; m++){
            int nr = r + mover[m];
            int nc = c + movec[m];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue; //범위에 벗어난다면
            if(visited[nr][nc] || !map[nr][nc]) continue; //이미 방문했다면
            dfs(nr,nc);
        }



    }
}