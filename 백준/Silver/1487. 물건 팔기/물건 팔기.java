import java.util.*;
import java.io.*;

/**
 * 세준이의 상품을 사려는 사람은 총 N명
 * 최대 한도
 * 세준이의 파는 가격이 더 높으면 안 사고
 * 파는 가격이 한도보다 낮으면 파는 가격에 산다.
 *
 * 세준이의 이익을 최대로 하는 가격은?
 * 최대 가격이 여러개라면 가장 낮은 가격
 *
 */
public class Main {
    static class Price {
        int maxPrice;
        int delivery;

        public Price(int maxPrice, int delivery){
            this.maxPrice = maxPrice;
            this.delivery = delivery;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Price[] prices = new Price[N];
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int max_price = Integer.parseInt(st.nextToken());
            int delivery_price = Integer.parseInt(st.nextToken());

            prices[i] = new Price(max_price, delivery_price);
        }

        Arrays.sort(prices, (o1,o2)->{
           return o1.maxPrice - o2.maxPrice;
        });
        //maxPrice 순으로 정렬

        int answer = 0;
        int price = 0;
        for(int i=0; i < N; i++){
            int standard = prices[i].maxPrice;
            int total = 0;
            for(int j =i; j < N; j++){
                if(prices[j].maxPrice >= standard){
                    //만약에 standard로 팔 건데 배달비가 더 나와서 -이면 그냥 안 팔음
                    if(standard - prices[j].delivery < 0) continue;
                    //스탠다드보다 크거나 같다면
                    total += standard;
                    total -= prices[j].delivery;
                }
            }

            if(answer < total){
                answer = total;
                price = standard;
            }


        }

        System.out.println(price);







    }
}