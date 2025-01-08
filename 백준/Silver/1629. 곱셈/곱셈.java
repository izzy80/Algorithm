import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C= Integer.parseInt(st.nextToken());

        System.out.println(pow(A,B,C));
    }

    public static long pow(long a,long b, long c){
        if(b==1){//지수가 1이면
            return a%c;
        }
        long ret=pow(a,b/2,c); //지수법칙 적용

        //모듈러 법칙 적용
        if(b%2==1) return (ret*ret%c)*a%c; //지수가 홀수라면 a를 더 곱해준다
        return (ret*ret)%c;
    }
}