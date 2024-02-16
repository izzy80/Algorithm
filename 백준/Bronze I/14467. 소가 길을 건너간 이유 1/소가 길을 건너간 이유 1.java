import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int[] cow = new int[10+1];
        Arrays.fill(cow, -1);

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()); //소 번호
            int location = Integer.parseInt(st.nextToken()); //왼쪽 0,  오른쪽 1

            if(location != cow[num] && cow[num] != -1) cnt++;
            cow[num] = location;
        }

        System.out.println(cnt);
    }
}