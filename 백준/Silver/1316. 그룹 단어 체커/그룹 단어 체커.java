import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
a : 97
z : 122
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer =0;
        for(int i=0; i< N; i++){
            int[] alpha = new int[26];
            boolean[] check = new boolean[26];

            String str = br.readLine();
      
            boolean flag = true;
            for(int j = 0; j < str.length(); j++){
                char c = str.charAt(j); //a
                int idx = c-97;

                if(!check[idx]){//방문하지 않았다면
                    alpha[idx] = j;
                    check[idx] = true;
                }
                else{//방문했다면
                    if(j - alpha[idx] > 1){ //1보다 크다는 것은 바로 옆에 있지 않다는 것
                        flag = false;
                        break;
                    }
                    else if(j - alpha[idx] == 1){ //1이라면
                        alpha[idx] = j;
                    }
                }
            }

            if(flag){//flag가 true면 연속해서 문자가 나타남
                answer++;
            }
        }
        System.out.println(answer);
    }
}