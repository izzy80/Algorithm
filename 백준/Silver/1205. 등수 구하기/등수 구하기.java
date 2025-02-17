import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //리스트에 있는 점수 N개
        int new_score = Integer.parseInt(st.nextToken()); //태수의 새로운 점수
        int P = Integer.parseInt(st.nextToken()); //랭킹 리스트에 올라갈 수 있는 점수

        Integer[] arr = new Integer[N];
        if(N != 0){
            st = new StringTokenizer(br.readLine());

            for(int i=0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            //solve
            Arrays.sort(arr, (o1,o2) -> o2-o1);

            //마지막 숫자랑 비교
            if(N == P && arr[N-1] >= new_score){
                System.out.println(-1);
            }
            else{
                int rank = 1;
                for(int i=0; i < N; i++){
                    if(new_score < arr[i]){
                        rank++; 
                    }
                    else break;
                }
                System.out.println(rank); 
            }
        }
        else{
            System.out.println(1);
        }

    }
}