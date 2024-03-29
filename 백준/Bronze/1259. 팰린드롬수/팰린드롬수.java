import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        while ((str = br.readLine()) != null){
            if(str.equals("0")){
                return;
            }

            StringBuilder sb = new StringBuilder();

            for(int i=str.length()-1; i>=0; i--){
                sb.append(str.charAt(i));
            }

            if(sb.toString().equals(str)){
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
        }
        br.close();

    }
}