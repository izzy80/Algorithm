import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int num_A = Integer.parseInt(st.nextToken());
        int num_B = Integer.parseInt(st.nextToken());

        int[] A = new int[num_A];
        int[] B = new int[num_B];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i< num_A; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i< num_B; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);


        //이분탐색
        List<Integer> answer = new LinkedList<>();

        for(int i=0; i<num_A; i++ ){
            int start = 0;
            int end = B.length - 1;

            int number = A[i]; //B에 있는지 확인할 A요소

            boolean flag = false;
            while(start <= end){
                int mid = (end+start)/2;

                if(B[mid] == number){ //B에 숫자가 있다면
                    flag = true;
                    break;
                }
                else if(B[mid] < number){
                    //A요소가 B[mid]보다 크다면
                    start = mid+1;
                }
                else{
                    //A요소가 B[mid]보다 작다면
                    end = mid-1;
                }

            }
            if(!flag){
                answer.add(number);
            }
        }
        int size = answer.size();
        System.out.println(size);

        StringBuilder sb = new StringBuilder();
        Collections.sort(answer);

        if(size!=0){
            for(Integer value : answer){
                sb.append(value).append(" ");
            }
        }
        System.out.println(sb.toString());



    }
}