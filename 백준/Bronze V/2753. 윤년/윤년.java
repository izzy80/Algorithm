import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
윤년이면 1, 아니면 0
4의 배수 O && 100의 배수 X
400의 배수 O
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Year = Integer.parseInt(br.readLine());

        int answer = 0;

        if((Year % 4 == 0 && Year % 100 != 0) || Year % 400 == 0){
            answer = 1;
        }
        System.out.println(answer);

    }
}