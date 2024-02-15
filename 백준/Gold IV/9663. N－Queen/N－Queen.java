import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static int answer;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        solve(0);
        System.out.println(answer);

    }

    private static void solve(int depth) { //depth는 행
        //arr[depth] = i 몇 번째 행(depth)에 몇 번째 열(i)이 들어가는지
        if(depth==N){ //행을 다 탐색하면
            answer++;
            return;
        }

        for(int i=0; i<N; i++){// 모든 경우의 수의 열
           arr[depth] = i;

           if(Check(depth)){  // 해당 depth(행)과 i(열)에 퀸을 놓을 수 있는지 확인
               solve(depth+1);
           }
        }

    }

    private static boolean Check(int row) {

        for(int c = 0; c < row; c++){
            if(arr[c] == arr[row]) return false;
            // 이전의 행들에 있는 컬럼위치와 새로 들어온 컬럼의 위치가 같은지 다른지
            // 같다면 더 이상 안으로 들어가지 못 하고 return된다.
            if(Math.abs(row - c) == Math.abs(arr[row] - arr[c])) return false;
            //대각선에 포함되어 있다면
        }
        return true;
    }
}