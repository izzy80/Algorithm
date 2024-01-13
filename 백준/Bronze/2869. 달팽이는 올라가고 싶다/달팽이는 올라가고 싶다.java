import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); //달팽이가 낮에 올라가는 거리
        int B = Integer.parseInt(st.nextToken()); //달팽이가 밤에 미끄러지는 거리
        int V = Integer.parseInt(st.nextToken()); //나무의 길이

        int day = (V - B)/ (A-B);

        if((V - B)% (A-B) != 0){
            day++;
        }

        System.out.println(day);

    }
}