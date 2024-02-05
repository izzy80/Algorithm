import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] origin = new int[N]; //원본 배열 : 찾는 숫자
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i< N; i++){
            int num = Integer.parseInt(st.nextToken());
            origin[i] = num;
        }
        int[] B = Arrays.copyOf(origin, N);
        Arrays.sort(B);
//        System.out.println(Arrays.toString(origin));

        List<Integer> list = new ArrayList<>();
        int prev = 0;
        int idx = 0;
        while(idx < N){
            int now = B[idx++];
            if (prev != now) {
                list.add(now); //찾는 숫자가 있어야할 배열
            }
            prev = now;
        }

//        for (Integer i : list) {
//            System.out.print(i + " ");
//        }
        int[] C = new int[list.size()];
        int id = 0;
        for (Integer i : list) {
            C[id++] = i;
        }

//        System.out.println(Arrays.toString(C));

        //이분탐색
        StringBuilder sb = new StringBuilder();

        for(int i =0 ; i < N; i++){
            int findNum = origin[i];
//            System.out.println(findNum);
            int start =0;
            int end = C.length-1;
            int answer = 0;
            while(start <= end){
                int mid = (start+end)/2;

                if(C[mid] == findNum){
                    answer = mid;
                    sb.append(mid).append(" ");
                    break;
                }
                else if(C[mid] < findNum){
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