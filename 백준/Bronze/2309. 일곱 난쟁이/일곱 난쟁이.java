import java.util.*;
import java.io.*;

public class Main {
    static int[] height;
    static boolean[] visited = new boolean[9];
    static int total;
    static StringBuilder sb = new StringBuilder();
    static boolean found = false; // 정답을 찾았는지 여부

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        height = new int[9];
        total = 0;
        for(int i=0; i < 9; i++){
            int num = Integer.parseInt(br.readLine());
            height[i] = num;
            total += num;
        }
        Arrays.sort(height);

        //2개 뽑음
        dfs(0,0);

        //출력
        System.out.println(sb.toString());
    }

    static public void dfs(int idx, int depth){
        if (found) return; // 정답을 찾았으면 더 이상 탐색하지 않음
        if(depth == 2){
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                if (visited[i]) sum += height[i];
            }
            if (total - sum == 100) {
                for (int i = 0; i < 9; i++) {
                    if (!visited[i]) sb.append(height[i]).append("\n");
                }
                found = true; // 정답을 찾았음을 표시
            }
            return;
        }
        for(int i=idx; i < 9; i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(i, depth+1);
            visited[i] = false;
        }
    }
}