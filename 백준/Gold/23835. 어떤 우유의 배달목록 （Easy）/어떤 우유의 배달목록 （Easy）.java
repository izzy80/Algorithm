import java.util.*;

public class Main {
    static List<Integer>[] arr = new List[1001];
    static int[] route = new int[1001];
    static int[] milk = new int[1001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= 1000; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] s = scanner.nextLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            arr[a].add(b);
            arr[b].add(a);
        }

        int q = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < q; i++) {
            String[] s = scanner.nextLine().split(" ");
            if (s[0].equals("1")) {
                int u = Integer.parseInt(s[1]);
                int v = Integer.parseInt(s[2]);
                dfs(u, 0, v, 0);
            } else {
                int x = Integer.parseInt(s[1]);
                System.out.println(milk[x]);
            }
        }
    }

    static boolean dfs(int now, int prev, int end, int count) {
        route[count] = now;
        if (now == end) {
            for (int i = 0; i <= count; i++) {
                milk[route[i]] += i;
            }
            return true;
        }

        boolean flag = false;
        for (int i : arr[now]) {
            if (i == prev) {
                continue;
            }
            if (dfs(i, now, end, count + 1)) {
                flag = true;
            }
        }

        return flag;
    }
}
