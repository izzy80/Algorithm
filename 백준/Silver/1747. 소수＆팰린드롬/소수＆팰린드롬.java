import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        //N보다 크거나 같은데, 이제 소수이면서 팰린드롬인데 가장 작은 수
        int max = Integer.MAX_VALUE;
        for(int i=N; i <= max; i++){
            if(check(i)){ ///소수 체크
                if(palen(i)){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
    public static boolean check(int num){
        if(num ==1){
            return false;
        }

        for(int i=2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }

    public static boolean palen(int num){
        StringBuilder sb = new StringBuilder();
        String opp = sb.append(num).reverse().toString();

        if(String.valueOf(num).equals(opp)) return true;
        else return false;
    }
}