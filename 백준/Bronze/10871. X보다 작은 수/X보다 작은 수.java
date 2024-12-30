import java.util.*;
import java.io.*;
//arr에서 X보다 작은 수 출력
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //정수
        int X = Integer.parseInt(st.nextToken()); //숫자


        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < N; i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp < X) sb.append(tmp).append(" ");
        }

        //출력
        System.out.println(sb.toString());







    }
}