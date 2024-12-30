import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int i=0; i < N; i++){
            String str = br.readLine();

            if(check(str)){
                answer++;
            }
        }

        //출력
        System.out.println(answer);
    }

    static public boolean check(String str){
        int[] alpha = new int[26];
        int idx = (int)str.charAt(0)-'a';
        alpha[idx] = 1;
        for(int i=1; i < str.length(); i++){
            int cur = (int)str.charAt(i)-'a';
            if(str.charAt(i)!= str.charAt(i-1)){//앞이랑 달라
                if(alpha[cur]!=0){//0이 아니야. 이미 앞에서 한 번 나옴
                    //그룹 단어가 아님
                    return false;
                }
                else{
                    alpha[cur]++;
                }
            }
            else{
                alpha[cur]++;
            }
        }
        return true;
    }
}