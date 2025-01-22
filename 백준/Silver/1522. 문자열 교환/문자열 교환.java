import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int aCnt = 0;
        int answer = Integer.MAX_VALUE;

        //1. 단어 안의 a의 갯수 구하기
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == 'a') aCnt++;
        }

        //2 str의 내부의 a의 갯수만큼 자릿수를 자른다.
        //슬라이딩 윈도우를 사용해서 그 자릿수 내부에 b의 개수가 몇 개인지 센다.
        for(int i=0; i < str.length(); i++){
            int bCnt = 0;
            for(int j=i; j<i+aCnt; j++){//슬라이딩 윈도우
                if(str.charAt((j+str.length()) % str.length()) == 'b') bCnt++;
            }
            answer = Math.min(answer, bCnt);
        }

        //출력
        System.out.println(answer);
    }
}