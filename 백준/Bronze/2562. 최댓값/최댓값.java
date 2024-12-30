import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.MIN_VALUE;
        int max_idx = 0;
        for(int i=0; i < 9; i++){
            int tmp = Integer.parseInt(br.readLine());

            if(tmp > max) {
                max = tmp;
                max_idx = i;
            }
        }

        System.out.println(max);
        System.out.println(max_idx+1);




    }

}