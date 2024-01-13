import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer,Integer> hm = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i< N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(hm.isEmpty()){
                hm.put(num,1);
            }
            else{//안 비어있다면
                if(hm.containsKey(num)){
                    hm.put(num,hm.get(num)+1);
                }
                else{
                    hm.put(num,1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i< M; i++){
            int cardNumber = Integer.parseInt(st.nextToken());
            int cardCnt = 0;
            if(hm.get(cardNumber) != null){
                cardCnt = hm.get(cardNumber);
            }
            sb.append(cardCnt).append(" ");
        }

        System.out.println(sb.toString());





    }
}