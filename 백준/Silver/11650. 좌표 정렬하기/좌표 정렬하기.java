import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] arr = new int[N][2];
        for(int i =0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.deepToString(arr));

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){//x좌표 값이 같다면
                    return o1[1] - o2[1]; //y좌표 값 기준으로 오름차순
                }
                return o1[0] - o2[0]; //x좌표 값을 기준으로 오름차순
            }
        });

        for(int i=0; i<N; i++){
            for(int j =0 ; j < 2; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }//main
}