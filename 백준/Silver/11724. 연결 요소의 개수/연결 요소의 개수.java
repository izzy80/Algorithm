import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
방향 없음 -> 양방향

 */
public class Main {
    static int N;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken()); //정점의 개수
        int M = Integer.parseInt(st.nextToken()); //간선의 개수
        list = new ArrayList[N+1];

        for(int i=0; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken()); //끝점
            int V = Integer.parseInt(st.nextToken()); //끝점

            list[U].add(V);
            list[V].add(U);
        }

//        for (ArrayList<Integer> integers : list) {
//            System.out.println(integers);
//        }

        visited = new boolean[N+1];

        int cnt =0;
        for(int i=1; i<= N; i++){
            if(!visited[i]){
                visited[i] = true;
                DFS(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void DFS(int idx) {
        for(int i=0; i < list[idx].size(); i++){//list의 사이즈만큼 돌아
            if(!visited[list[idx].get(i)]){
                visited[list[idx].get(i)] = true;
                DFS(list[idx].get(i)); //들어감
            }
        }

    }


}