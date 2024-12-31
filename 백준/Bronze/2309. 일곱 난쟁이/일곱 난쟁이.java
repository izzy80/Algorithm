import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] height = new int[9];
        int sum = 0;
        for(int i=0; i < 9; i++){
            int num = Integer.parseInt(br.readLine());
            height[i] = num;
            sum += num;
        }

        Arrays.sort(height);
        int A = 0;
        int B = 0;
        outer : for(int i=0; i < 8; i++){
            for(int j=i+1; j<9; j++){
                int tmp = height[i]+height[j];
                if(sum - tmp == 100) {
                    A = i;
                    B = j;
                    break outer;
                }
            }
        }

        for(int i=0; i < 9; i++){
            if(i == A || i == B){
                continue;
            }
            System.out.println(height[i]);
        }




    }
}