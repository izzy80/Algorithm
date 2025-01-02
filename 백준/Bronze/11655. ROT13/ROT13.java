import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];

            if (!Character.isLetter(ch)) {
                continue;
            }

            int n = ch + 13;

            if ((Character.isUpperCase(ch) && n > 'Z') || (Character.isLowerCase(ch) && n > 'z')) {
                n -= 26;
            }

            chars[i] = (char) n;
        }

        System.out.println(chars);


    }
}