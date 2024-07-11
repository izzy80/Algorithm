import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[][] map;
    static long[][] answer_map;

    public static void main(String[] args) throws IOException{
        //1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 8;
        map = new long[N][N];
        answer_map = new long[N][N]; //답

        StringTokenizer st;
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < N; j++){
                map[i][j] = Long.parseLong(st.nextToken());
            }
        }
        String dir = br.readLine(); //방향키

        //2. solve
        solve(dir);

        //3. print
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < N; i++){
            for(int j=0; j < N; j++){
                sb.append(answer_map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static public void solve(String dir){
        Queue<Long> q;
        switch (dir){
            case "U" :
                for(int c=0; c < N; c++){
                    q = new LinkedList<>();
                    for(int r = 0; r < N; r++){
                        if(map[r][c] != 0){
                            q.add(map[r][c]);
                        }
                    }
                    //한 줄 끝
                    fillRow(q, c, 0);
                }
                break;
            case "D" :
                for(int c=0; c < N; c++){
                    q = new LinkedList<>();
                    for(int r = N-1; r >= 0; r--){
                        if(map[r][c] != 0){
                            q.add(map[r][c]);
                        }
                    }
                    //한 줄 끝
                    fillRow(q,c,N-1);
                }
                break;
            case "L" :
                for(int r=0; r < N; r++){
                    q = new LinkedList<>();
                    for(int c = 0; c < N; c++){
                        if(map[r][c] != 0){
                            q.add(map[r][c]);
                        }
                    }
                    //한 줄 끝
                    fillCol(q, r,0);
                }
                break;
            case "R" :
                for(int r=0; r < N; r++){
                    q = new LinkedList<>();
                    for(int c = N-1; c >= 0; c--){
                        if(map[r][c] != 0){
                            q.add(map[r][c]);
                        }
                    }
                    //한 줄 끝
                    fillCol(q, r,N-1);
                }
                break;
        }
    }

    static public void fillRow(Queue<Long> q, int c, int start){
        int idx = start;
        while(!q.isEmpty()){
            long tmp = q.poll();
            if(q.peek() == null){
                answer_map[idx][c] = tmp;
                q.poll();
            }
            else{
                long next = q.peek();
                if(tmp == next){//같으면
                    answer_map[start == 0 ? idx++ : idx--][c] = tmp * 2;
                    q.poll();
                }
                else{//다르면
                    answer_map[start == 0 ? idx++ : idx--][c] = tmp;
                }
            }
        }
    }

    static public void fillCol(Queue<Long> q, int r, int start){
        int idx = start;
        while(!q.isEmpty()){
            long tmp = q.poll();
            if(q.peek() == null){
                answer_map[r][idx] = tmp;
                q.poll();
            }
            else{
                long next = q.peek();
                if(tmp == next){//같으면
                    answer_map[r][start == 0 ? idx++ : idx--] = tmp*2;
                    q.poll();
                }
                else{//다르면
                    answer_map[r][start == 0 ? idx++ : idx--] = tmp;
                }
            }
        }
    }
}