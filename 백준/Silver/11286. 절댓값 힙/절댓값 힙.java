import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
x가 0이 아니라면 배열에 x라는 값을 추가
x가 0이라면 배열에서 절대값이 가장 작은 값을 출력하고 그 값을 배열에서 제거
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) == Math.abs(o2)){//절대값이 같은 경우 -1,1
                    return o1-o2; //더 작은 값을 출력
                }
                return Math.abs(o1)-Math.abs(o2);//절대값이 작은 순서대로 출력
            }
        });

        for(int i=0; i < N ;i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){//0이면
                if(pq.isEmpty()){//pq가 비어있다면 0출력
                    System.out.println(0);
                }
                else{
                    System.out.println(pq.poll());//가장 작은게 출력되어야함
                }
            }
            else{//0이 아니면
                pq.add(num);
            }
        }
    }
}