import java.util.*;
import java.io.*;

/**
 * - 초밥의 종류를 번호로 표현
 * - 한 위치부터 k개의 접시를 연속해서 먹으면 할인된 가격
 * 한 고객에게 번호가 쓰인 쿠폰을 발행하는데 위 행사에 참여하면 이 초밥 무료로 제공. 없으면 만들어서 제공
 * 가능한 다양한 초밥 먹으려고 함.
 * k = 4, 30번 초밥
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //초밥 벨트에 놓인 접시의 수
        int d = Integer.parseInt(st.nextToken()); //초밥의 가짓수
        int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken()); //쿠폰 번호

        int[] sushi = new int[N]; //k만큼 뒤에 더 넣어주기
        int[] eaten = new int[d+1]; //먹은 초밥

        for(int i=0; i < N; i++){
            sushi[i] = Integer.parseInt(br.readLine());
        }

        //solve
        //0. 공짜 쿠폰은 이미 먹었다고 체크
        int count = 1;
        eaten[c]++;

        //1. 처음 0번부터 k개수만큼 먹었을 때 파악해 값을 선정
        for(int i=0; i < k; i++){
            if(eaten[sushi[i]] == 0){
                //아직 먹었다고 체크 안 했으므로 중복x
                count++;
            }
            eaten[sushi[i]]++;
        }

        //2. 윈도우 이동
        //1번부터 n-1(마지막)까지 이동
        int max = count;
        for(int i = 1; i < N; i++){
            //end 이동
            int end = (i+k-1)%N;
            if(eaten[sushi[end]] == 0){
                count++;
            }
            eaten[sushi[end]]++;

            //start 이동
            eaten[sushi[i-1]]--; //start점 이동했으니까 이전 초밥 제거
            if(eaten[sushi[i-1]] == 0){
                count--;
            }
            
            max = Math.max(max, count);
        }

        //print
        System.out.println(max);
    }
}