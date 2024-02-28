import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken()); //n번의 가위질
        long k = Long.parseLong(st.nextToken()); //k개의 색종이


        long left = 0;
        long right = n/2; //가위질의 최대 수
        String answer = "NO";
        while(left <= right){
            long mid = (left+right)/2;
            long col = n - mid;

            //mid를 해서 나온 색종이의 수
            long cnt = (mid+1) * (col+1);   //색종이의 개수를 구하는 로직

            if(cnt == k){
                answer = "YES";
                break;
            }
            else if(cnt > k){
                right = mid-1;
            }
            else{//색종이의 수가 k보다 작다면
                left = mid+1;
            }

        }
        System.out.println(answer);
    }
}