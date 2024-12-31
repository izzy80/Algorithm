import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] alpha = new int[26];

        for(int i=0; i < str.length(); i++){
            int idx = (int)str.charAt(i)-'a';
            alpha[idx]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < 26; i++){
            sb.append(alpha[i]).append(" ");
        }
        System.out.println(sb.toString());


    }
}