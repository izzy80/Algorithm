import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int)Math.pow(2,N);
        cnt =0;
        z(size,r,c);
        System.out.println(cnt);
    }

    private static void z(int n, int r, int c) {
        if(n == 1){
            return;
        }
        int half = n/2;
        if(r < half && c < half){
            //좌상
            z(half, r,c);
        }
        else if(r < half && c >= half){
            //우상
            cnt += n * n/4;
            z(half, r, c - half);
        }
        else if(r >= half && c < half){
            //좌하
            cnt += (n * n/4)*2;
            z(half, r-half, c);
        }
        else{
            cnt += (n * n/4)*3;
            z(half, r-half, c-half);
        }


    }
}