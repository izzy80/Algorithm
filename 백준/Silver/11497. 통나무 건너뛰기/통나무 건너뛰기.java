import java.util.*;
import java.io.*;

/*
높이 차 최소
통나무들로 만들 수 있는 최소 난이도
처음과 마지막은 연결되어 있음
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc =0; tc < T; tc++){
            int N = Integer.parseInt(br.readLine()); //통나무의 갯수

            int[] tree = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i < N; i++){
                tree[i] = Integer.parseInt(st.nextToken());
            }
            //solve
            //정렬
            Arrays.sort(tree);
            //디큐 만들기

            int[] new_tree = new int[N];
            new_tree[N/2] = tree[N-1]; //마지막 숫자 집어넣음

            int now_right = (N/2)+1;
            int now_left = (N/2)-1;
            for(int i=N-2; i > 0; i-=2){
                new_tree[now_right++] = tree[i];
                if(i-1 < 0) continue;
                new_tree[now_left--] = tree[i-1];
            }
            if(N%2 == 0){
                //짝수면 맨 앞에 하나 고대로 붙여줌
                new_tree[0] = tree[0];
            }
//            System.out.println(Arrays.toString(new_tree));

            int answer = 0;
            answer = Math.max(answer,Math.abs(new_tree[0] - new_tree[N-1]));

            for(int i=0; i < N-1; i++){
                answer = Math.max(answer,Math.abs(new_tree[i] - new_tree[i+1]));
            }
            //print
            sb.append(answer).append("\n");
        }//tc

        System.out.println(sb.toString());
    }
}