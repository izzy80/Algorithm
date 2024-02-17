import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        boolean[][] visited = new boolean[N][N];
        String[][] answer = new String[N][N];

        for(int i=0;i<N; i++){
            //.으로 채우기
            Arrays.fill(answer[i],".");
        }

        //지뢰표시
        for(int i=0; i < N; i++){
            String str = br.readLine();
            for(int j=0; j< N; j++){
                map[i][j] = str.charAt(j);
            }
        }

        //방문처리
        for(int i=0; i < N; i++){
            String str = br.readLine();
            for(int j=0; j< N; j++){
                char c = str.charAt(j);
                if(c == 'x') visited[i][j] = true;
            }
        }


        //지뢰표시
        int[] mover = {-1,-1,-1,0,1,1,1,0};
        int[] movec = {-1,0,1,1,1,0,-1,-1};
        for(int i=0; i< N; i++){
            for(int j=0; j< N; j++){
                int cnt = 0; //상하좌우대각선의 지뢰의 개수
                if(visited[i][j]){//방문했어
                    for(int m=0;m<8;m++){
                        int nr = i+mover[m];
                        int nc = j+movec[m];

                        if(nr <0 || nr >= N || nc <0 || nc >= N) continue;
                        if(map[nr][nc] == '*') cnt++;
                    }
                    answer[i][j] = Integer.toString(cnt);

                    if(map[i][j] == '*'){
                        for(int k=0; k< N; k++){
                            for(int l =0; l < N; l++){
                                if(map[k][l] == '*'){
                                    answer[k][l] = "*";
                                }
                            }
                        }
                    }
                }



            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i < N; i++){
            for(int j=0; j < N; j++){
                sb.append(answer[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());



    }
}