import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int Y_cnt = 0;
        int M_cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++){
            int time = Integer.parseInt(st.nextToken());

            //영식 요금제
            Y_cnt += (time/30)*10+10;
            M_cnt += (time/60)*15+15;
        }

        if(Y_cnt > M_cnt){
            System.out.println("M "+M_cnt);
        }
        else if(Y_cnt < M_cnt){
            System.out.println("Y "+Y_cnt);
        }
        else{
            System.out.println("Y M "+Y_cnt);
        }




    }
}