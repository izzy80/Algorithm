import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] train = new int[N+1][20+1];

        for(int i=0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());

            int idx = Integer.parseInt(st.nextToken());
            int seat =0;
            switch (number){
                case 1:
                    seat = Integer.parseInt(st.nextToken());
                    if(train[idx][seat] == 0) train[idx][seat]++;
                    break;
                case 2:
                    seat = Integer.parseInt(st.nextToken());
                    if(train[idx][seat] == 1) train[idx][seat]--;
                    break;
                case 3:
                    //i번째 기차에 앉은 승객들이 모두 한칸씩 뒤로 간다.
                    int tmp = train[idx][1];
                    for(int j = 20; j >= 2; j--){
                        train[idx][j] = train[idx][j-1];
                    }
                    train[idx][1] = 0;
                    break;
                case 4:
                    for(int j = 1; j <= 19; j++){
                        train[idx][j] = train[idx][j+1];
                    }
                    train[idx][20] = 0;
                    break;
            }

        }

        //은하수 처리
        HashSet<String> hs = new HashSet<>();
//        System.out.println(Arrays.deepToString(train));

        StringBuilder sb;
        for(int i=1; i<= N; i++){
            sb = new StringBuilder();
            for(int j =1; j<= 20; j++){
                if(train[i][j] == 1){
                    sb.append("B"); //있음
                }
                else{
                    sb.append("W");
                }
            }
            hs.add(sb.toString());

        }

        System.out.println(hs.size());

    }
}