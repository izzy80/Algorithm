import java.util.*;
import java.io.*;

/**
 * N장의 공유 카드
 * N장의 팀 숫자 카드
 *
 * 문제 자체가 share *team에서 최대로 나올 수 있는 team에서 k장을 빼는 것
 * 그렇게 k장을 빼고 나서 share를 곱해서 나올 수 있는 가장 큰 수를 구하는 것
 *
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());  //팀 숫자카드 중 k장 견제

        int[] share = new int[N]; //공유 숫자카드
        int[] team = new int[N];  //팀 숫자카드
        st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++){
            share[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++){
            team[i] = Integer.parseInt(st.nextToken());
        }

        //k장을 뺌
        for(int k = 0; k < K; k++){
            int max = Integer.MIN_VALUE;
            int idx = 0;
            for(int i=0; i < N; i++){
                for(int j=0; j < N; j++){
                    if(team[j] == Integer.MIN_VALUE) continue;
                    if(max < share[i] * team[j]) {
                        max = Math.max(max,share[i] * team[j]);
                        idx = j; //팀의 idx 저장
                    }
                }
            }
            team[idx] = Integer.MIN_VALUE;
        }

        //max 값 구하기
        int answer = Integer.MIN_VALUE;
        for(int i=0; i < N; i++){
            for(int j=0; j < N; j++){
                if(team[j] == Integer.MIN_VALUE) continue;
                if(answer < share[i] * team[j]) {
                    answer = Math.max(answer,share[i] * team[j]);
                }
            }
        }

        System.out.println(answer);

    }
}