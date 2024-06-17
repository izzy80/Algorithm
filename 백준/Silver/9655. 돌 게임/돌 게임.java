import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N%2 == 0){ //짝수면 창영
            System.out.println("CY");
        }
        else{
            System.out.println("SK");
        }
    }
}