import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        int[] stock = new int[14];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<14; i++){
            stock[i] = Integer.parseInt(st.nextToken());
        }

        int junhyeonResult = BNP(stock, money);
        int sungminResult = TIMING(stock, money);

        if(junhyeonResult > sungminResult) {
            System.out.println("BNP");
        }
        else if(junhyeonResult < sungminResult) {
            System.out.println("TIMING");
        }
        else {
            System.out.println("SAMESAME");
        }
    }
    static int BNP(int chart[], int money) {

        int count = 0;
        int lmoney = money;

        for(int i = 0; i < 14; i++) {
            int now = lmoney/chart[i];
            count += now;
            lmoney -= now * chart[i];
        }

        return lmoney + count * chart[13];
    }

    static int TIMING(int chart[], int money) {

        int count = 0;
        int lmoney = money;
        int upCount = 0;
        int downCount = 0;
        int yesterday = chart[0];

        for(int i = 1; i < 14; i++) {
            int today = chart[i];

            if(today > yesterday) {
                upCount++;
                downCount = 0;
            }
            else if(today < yesterday) {
                downCount++;
                upCount = 0;
            }
            else {
                upCount = 0;
                downCount = 0;
            }

            if(upCount == 3) {
                if(count != 0) {
                    lmoney += today * count;
                }
                upCount = 0;
                count = 0;
            }

            else if(downCount == 3) {
                int now = lmoney / today;
                count += now;
                lmoney -= now * today;
            }
        }

        return lmoney + count * chart[13];
    }
}