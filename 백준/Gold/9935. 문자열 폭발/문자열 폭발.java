import java.util.*;
import java.io.*;

//투포인터?

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); //문자열
        String bomb = br.readLine(); //폭발문자열
        int str_len = str.length();
        int bomb_len = bomb.length();


        //2.solve
        Stack<Character> st = new Stack<>();
        for(int i=0; i < str_len; i++){
            int cnt = 0;
            st.push(str.charAt(i));

            if(st.size() >= bomb_len){
                //스택의 크기가 폭탄 문자열의 길이와 같아지면 돌기 시작
                for(int j=0; j < bomb_len; j++){
                    if(st.get(st.size() - bomb_len + j) == bomb.charAt(j)){
                        //get은 해당 인덱스의 문자를 가져옴
                        cnt++;
                    }

                    if(cnt == bomb_len){
                        for(int k = 0; k < bomb_len; k++){
                            st.pop();
                        }
                    }

                }
            }
        }

        String answer = "FRULA";
        StringBuilder sb = new StringBuilder();
        if(!st.isEmpty()){
            while(!st.isEmpty()){
                sb.append(st.pop());
            }
            answer = sb.reverse().toString();
        }


        //답
        System.out.println(answer);
    }
}