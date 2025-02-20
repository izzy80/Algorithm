import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0 ; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int T = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int i=0; i < N-2; i++){
            for(int j = 0; j < M-2; j++){
                ArrayList<Integer> numbers = new ArrayList<>();
                for(int k=i; k < i+3; k++){
                    for(int l = j; l <j+3; l++){
                        numbers.add(map[k][l]);
                    }
                }
                Collections.sort(numbers);

                int num = numbers.get(numbers.size()/2);
//                System.out.println("중앙값 = "+num);
                if(num >= T )answer++;
            }
        }
        System.out.println(answer);
    }
}