import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;
        char[] tmp = {'a','e','i','o','u'};
        while(!(str = br.readLine()).equals("#")){
            str = str.toLowerCase();
            int cnt = 0;
            for(int i=0; i < str.length(); i++){
                for(int j =0; j < tmp.length; j++){
                    if(str.charAt(i) == tmp[j]) cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}