import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    static int[] arr = new int[100001];

    static int[] move = new int[]{-1, 1,3};

    static int time;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Arrays.fill(arr, -1);


        BFS();

//        System.out.println(Arrays.toString(arr));
        System.out.println(arr[K]);
    }

    private static void BFS() {
        Queue<Integer> q = new LinkedList<>();

        arr[N] = 0;
        q.add(N);

        while(!q.isEmpty()){
            int cl = q.poll();
//            System.out.println(cl);

            for(int i=0; i<3;i++){
                int nl =0;
                if(move[i] == 3){
                    nl = 2*cl;
                }
                else{
                    nl = cl+move[i];
                }

                if(nl < 0 || nl > 100000) continue;
                if(arr[nl] != -1) continue;
                arr[nl] = arr[cl]+1;
//                System.out.println(arr[nl]);
                q.add(nl);
            }
        }


    }
}