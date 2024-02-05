import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //1. 값 집어넣기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] origin = new int[N]; //1. 원본 배열 : 찾는 숫자
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i< N; i++){
            int num = Integer.parseInt(st.nextToken());
            origin[i] = num;
        }

        int[] B = Arrays.copyOf(origin, N);
        Arrays.sort(B);

        List<Integer> list = new ArrayList<>(); //2. 중복 없앤 이분탐색할 배열
        int prev = 0;
        int idx = 0;
        while(idx < N){
            int now = B[idx++];
            if (prev != now) {
                list.add(now); //찾는 숫자가 있어야할 배열
            }
            prev = now;
        }

        //2. 이분탐색
        StringBuilder sb = new StringBuilder();

        for(int i =0 ; i < N; i++){
            int findNum = origin[i];
            int start =0;
            int end = list.size()-1;
            int answer = 0;
            while(start <= end){
                int mid = (start+end)/2;
                if(list.get(mid) == findNum){
                    answer = mid;
                    sb.append(mid).append(" ");
                    break;
                }
                else if(list.get(mid)  < findNum){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }
        System.out.println(sb.toString());

    }
}