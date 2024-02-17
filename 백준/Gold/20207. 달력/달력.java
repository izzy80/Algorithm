import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int S,E;
        int[] year = new int[365+1];
        for(int i=0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            for(int j=S; j<=E;j++){
                year[j]++;
            }
        }

        //계산하기
        int answer =0;

        int cnt =0;
        boolean flag = false; 
        int idx =1;
        int max = Integer.MIN_VALUE;
        while(idx < 366){
            if(year[idx] != 0){
               cnt++;
               max = Math.max(max, year[idx]);
               flag = true; 
            }
            
            else{//만약에 0이야
                answer+=cnt*max;
                cnt =0;
                max = Integer.MIN_VALUE;
                flag = false;
            }
            idx++;
        }
        if(flag){//flag가 true면 마지막 처리x
            answer+=cnt*max;
        }
        System.out.println(answer);
    }
}