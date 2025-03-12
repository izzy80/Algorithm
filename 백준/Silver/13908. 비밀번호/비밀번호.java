import java.util.*;
 
public class Main {
 
    static int n, m;
    static int count;
    static boolean[] visited;
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        n = scan.nextInt();
        m = scan.nextInt();
 
        visited = new boolean[10];
        for(int i = 0; i < m; i++) {
            visited[scan.nextInt()] = true;
        }
 
        backtracking(0, 0);
        System.out.println(count);
    }
 
    public static void backtracking(int idx, int cnt) {
        if(idx == n) {
            if(cnt == m) count++; 
            return;
        }
 
        for(int i = 0; i <= 9; i++) {
            if(visited[i]) {
                visited[i] = false;
                backtracking(idx + 1, cnt + 1);
                visited[i] = true;
            } else {
                backtracking(idx + 1, cnt);
            }
        }
    }
}