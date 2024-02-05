import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];

        HashSet<Integer> hs = new HashSet<>();

        for(int i=0; i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            A[i] = num;
            hs.add(num);
        }
        int[] B = new int[hs.size()];
        int idx = 0;
        for (int i : hs) {
            B[idx++] = i;
        }
        Arrays.sort(B); //정렬
//        System.out.println(Arrays.toString(B));


        StringBuilder sb = new StringBuilder();
        for(int i =0; i<N; i++){
            int find = A[i];

            int start =0;
            int end = B.length-1;
            int answer = 0;
            while(start <= end){
                int mid = (start + end)/2;

                if(B[mid] == find){
                    //계산하기
                    answer = mid;
                    sb.append(answer).append(" ");
                    break;
                }
                else if(B[mid]>find){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
        }
        System.out.println(sb.toString());
    }
}