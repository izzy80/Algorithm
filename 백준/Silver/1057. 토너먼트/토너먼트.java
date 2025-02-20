import java.util.*;
import java.io.*;

public class Main {
    static class Person {
        int idx;
        String name;

        public Person(int idx, String name){
            this.idx = idx;
            this.name = name;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //참가자의 수
        int kim = Integer.parseInt(st.nextToken()); //김지민의 번호
        int im = Integer.parseInt(st.nextToken()); //임한수의 번호

        int answer = -1;
        int cnt = 0;
        while(kim != im){
            kim = kim /2 + kim%2;
            im = im /2 + im%2;
            cnt++;
        }

        System.out.println(cnt > 0 ? cnt : answer);


    }
}