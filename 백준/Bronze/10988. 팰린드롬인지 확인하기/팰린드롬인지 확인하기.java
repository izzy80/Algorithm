import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        
        String str_new = sb.append(str).reverse().toString(); 
        
        if(str.equals(str_new)){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
}