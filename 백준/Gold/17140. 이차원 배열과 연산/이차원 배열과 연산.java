import java.util.*;
import java.io.*;

public class Main {
    public static int[][] map;
    public static int row_len, col_len;
    public static class Node implements Comparable<Node> {
        int num; //숫자
        int cnt; //등장횟수

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            // 등장 횟수 기준 오름차순, 숫자 기준 오름차순
            if (this.cnt == o.cnt) {
                return this.num - o.num;
            }
            return this.cnt - o.cnt;
        }
    }
    public static void main(String[] args) throws IOException{
        //1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[101][101];

        for(int i=0;i<3;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //2. solve
        row_len = 3;
        col_len = 3;
        
        int ans = -1;
        int cnt = 0;
        while(cnt <= 100) {
            if(map[r-1][c-1] == k) {
                ans = cnt;
                break;
            }

            if(row_len >= col_len) {
                row_sort();
            } else {
                col_sort();
            }
            cnt++;
        }

        //3. print
        System.out.println(ans);
    }

    public static void row_sort(){
        int[][] map_copy = new int[101][101];
        int col = 0;
        for(int i=0;i<row_len;i++) {
            HashMap<Integer, Integer> hash = new HashMap<>(); //숫자, 숫자의 개수 저장
            for(int j=0;j<col_len;j++) {
                if(map[i][j] == 0) continue;
                if(hash.containsKey(map[i][j])) {
                    hash.put(map[i][j], hash.get(map[i][j])+1);
                } else {
                    hash.put(map[i][j], 1);
                }
            }
            ArrayList<Node> list = new ArrayList<>(); //한 행에 대한 map의 정보를 list에 옮겨서 정렬
            for(Map.Entry<Integer, Integer> entry:hash.entrySet()) {
                list.add(new Node(entry.getKey(), entry.getValue()));
            }
            col = Math.max(col, list.size()*2); //숫자, 개수로 2개라서 *2
            Collections.sort(list);
            for(int p=0;p<list.size();p++) {
                if(p >= 50) break;
                Node node = list.get(p);
                map_copy[i][2*p] = node.num;
                map_copy[i][2*p+1]= node.cnt;
            }
        }
        col_len = Math.min(99, col);
        map = map_copy;
    }

    public static void col_sort(){
        int[][] map_copy = new int[101][101];
        int row = 0;
        for(int j=0;j<col_len;j++) {
            HashMap<Integer, Integer> hash = new HashMap<>();
            for(int i=0;i<row_len;i++) {
                if(map[i][j] == 0) continue;
                if(hash.containsKey(map[i][j])) {
                    hash.put(map[i][j], hash.get(map[i][j])+1);
                } else {
                    hash.put(map[i][j], 1);
                }
            }
            ArrayList<Node> list = new ArrayList<>();
            for(Map.Entry<Integer, Integer> entry:hash.entrySet()) {
                list.add(new Node(entry.getKey(), entry.getValue()));
            }
            row = Math.max(row, list.size()*2);
            Collections.sort(list);
            for(int p=0;p<list.size();p++) {
                if(p >= 50) break;
                Node node = list.get(p);
                map_copy[2*p][j] = node.num;
                map_copy[2*p+1][j]= node.cnt;
            }
        }
        row_len = Math.min(99, row);
        map = map_copy;
    }

}