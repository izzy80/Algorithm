import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//만들 수 있는 최소값과 최대값
public class Main {
    static int min,max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        solve(N,0);

        System.out.println(min + " "+max);
    }

    private static void solve(int n,int cnt) {
        String str = Integer.toString(n);
        int numberLen = str.length();
        if(numberLen == 1){
            if(n%2 != 0){
                cnt++;
            }
            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
            return;
        }

        if(numberLen == 2){
            int first = n/10;
            int second = n%10;
            if(first % 2 != 0) cnt++;
            if(second % 2 != 0) cnt++;
            n = n/10 + n%10;
            solve(n, cnt);
        }
        else{ //3이상일 때
            //일단 홀수찾기
            for(int i=0; i< str.length(); i++){
                int nn = str.charAt(i)-'0';
                if(nn%2!=0) cnt++;
            }

            //쪼개기
            for(int i=1; i <= numberLen-2; i++){
                for(int j=i+1; j <= numberLen-1; j++){
                    int f = Integer.parseInt(str.substring(0,i));
                    int s = Integer.parseInt(str.substring(i,j));
                    int t = Integer.parseInt(str.substring(j,numberLen));

                    solve(f+s+t, cnt);
                }
            }
        }
    }
}