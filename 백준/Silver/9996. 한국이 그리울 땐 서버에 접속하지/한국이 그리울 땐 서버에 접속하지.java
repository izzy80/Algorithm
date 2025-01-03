import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        String[] p = pattern.split("\\*");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String word = br.readLine(); // 탐색할 문자

            // target 문자열의 최소 길이 조건 확인
            if (word.length() < p[0].length() + p[1].length()) {
                sb.append("NE").append("\n");
                continue;
            }

            String start = word.substring(0, p[0].length()); // word 앞부분
            String end = word.substring(word.length() - p[1].length()); // word 뒷부분

            if (start.equals(p[0]) && end.equals(p[1])) {
                sb.append("DA").append("\n"); // 만들 수 있음
            } else {
                sb.append("NE").append("\n"); // 만들 수 없음
            }
        }

        System.out.println(sb.toString());
    }
}