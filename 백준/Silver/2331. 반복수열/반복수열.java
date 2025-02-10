import java.util.*;
import java.io.*;


public class Main {
    static ArrayList<Integer> number = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); //시작숫자
        int multi = Integer.parseInt(st.nextToken()); //곱하기

        number.add(start);
        int now = start;

        while(true){
            int next = 0;
            while(now > 0){
                next += (int)Math.pow(now%10,multi);
                now /=10;
            }
            if(number.contains(next)){
                System.out.println(number.indexOf(next));
                break;
            }
            now = next;
            number.add(now);
        }


    }
}