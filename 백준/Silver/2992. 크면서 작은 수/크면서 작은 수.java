import java.util.*;
import java.io.*;

/**
 * 1. X와 구성이 같아야함
 * 1-1. 구성이 같다?
 * 수를 이루고 있는 각 자리수가 같다.
 * 123 321 -> ok
 * 123 432 -> no
 * 2. X보다 큰 수 중에서 가장 작은 수 출력
 *
 */
public class Main {
    static int[] numbers;
    static boolean[] visited;
    
    static int size;
    static int origin_number;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        size = str.length();
        origin_number = Integer.parseInt(str);

        numbers = new int[size];
        visited = new boolean[size];
        for(int i=0; i < str.length(); i++){
            numbers[i] = str.charAt(i) - '0';
        }
        Arrays.sort(numbers);

        // solve
        int[] num = new int[size];
        dfs(0, num);

        System.out.println(answer);



    }

    static public void dfs(int depth, int[] num){
        if(depth == size){
            StringBuilder sb = new StringBuilder();
            for(int i : num){
                if(i == -1) return;
                sb.append(i);
            }

            int n = Integer.parseInt(sb.toString());
//            System.out.println(n);
            if(answer == 0 && n > origin_number){
                answer = n;
            }
            return;
        }

        for(int i=0; i < size; i++){
            if(visited[i]) continue;
            visited[i] = true;
            num[depth] = numbers[i];
            dfs(depth+1, num);
            visited[i] = false;
            num[depth] = -1;
        }
    }
}