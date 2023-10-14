import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R,C;
    static char[][] map;

    static int[][] distj; //지훈
    static int[][] distf; //불

    static int[] mover = new int[]{-1,0,1,0};
    static int[] movec = new int[]{0,-1,0,1};

    static Queue<int[]> qj;
    static Queue<int[]> qf;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        distj = new int[R][C];
        distf = new int[R][C];

        for(int i=0; i<R;i++){
          Arrays.fill(distj[i], -1);
          Arrays.fill(distf[i], -1);
        }

        for(int i=0;i<R;i++){
            String str = br.readLine();
            for(int j=0;j<C;j++){
                map[i][j] = str.charAt(j);
            }
        }
//        System.out.println(Arrays.deepToString(map));

        int ans =0;

        qj = new LinkedList<>();
        qf = new LinkedList<>();

        for(int i=0; i<R;i++){
            for(int j=0; j< C;j++){
                if(map[i][j] == 'F'){
                    //불이 여러개라서 동시에 여러곳에서 출발해야할 수도 있어ㅓ서
                    distf[i][j] = 0;
                    qf.add(new int[]{i,j});
                }
                if(map[i][j] == 'J'){
                    distj[i][j] = 0;
                    qj.add(new int[]{i,j});
                }
            }
        }

        BFSF();
        ans = BFSJ();

        if(ans == -1){
            System.out.println("IMPOSSIBLE");
        }
        else{
            System.out.println(ans);
        }

    }//main

    private static int BFSJ() {
        //지훈이
        while(!qj.isEmpty()){
            int[] tmp = qj.poll();
            int cr = tmp[0];
            int cc = tmp[1];

            for(int m=0;m<4;m++){
                int nr = cr + mover[m];
                int nc = cc + movec[m];

                if(nr <0 || nr >= R || nc <0|| nc >= C){
                    //가장자리에서 벗어남
//                    System.out.println(Arrays.deepToString(distj));
                    return distj[cr][cc]+1;
                }
                if(map[nr][nc] == '#' || distj[nr][nc] >= 0) continue;
                if(distf[nr][nc] != -1 && distf[nr][nc] <= distj[cr][cc]+1) continue;
                //dist1[nr][nc] != -1 없으면 impossible만 뜬다. => -1이 아니라는 것은 한 번 지나왔다는 소리이므로
                distj[nr][nc] = distj[cr][cc]+1;
                qj.add(new int[]{nr,nc});
            }
        }
        return -1;
    }



    private static void BFSF() {

        while(!qf.isEmpty()){
            int[] tmp = qf.poll();
//            System.out.println(Arrays.toString(tmp));
            int cr = tmp[0];
            int cc = tmp[1];

            for(int m=0;m<4;m++){
                int nr = cr + mover[m];
                int nc = cc + movec[m];

                if(nr <0 || nr >= R || nc <0|| nc >= C) continue;
                if(map[nr][nc] == '#' || distf[nr][nc] >=0) continue;

                distf[nr][nc] = distf[cr][cc]+1;
                qf.add(new int[]{nr,nc});
            }
        }
//        System.out.println("distf출력");
//        System.out.println(Arrays.deepToString(distf));
    }
}