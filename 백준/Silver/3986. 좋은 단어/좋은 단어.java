import java.awt.image.ImagingOpException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        //배열에 순서대로 넣어주기
        for(int i=0; i<N; i++){
            words[i] = br.readLine();
        }

        //좋은 단어 check
        int answer = 0;
        for(int i=0; i < N; i++){
            String str = words[i];
            Stack<Character> st = new Stack<>();
            for(int j=0; j < str.length(); j++){
                if(st.isEmpty()){
                    st.push(str.charAt(j));
                }
                else{
                    if(st.peek()=='A'){
                        if(str.charAt(j)=='A') {
                            st.pop();
                        }
                        else{
                            st.push(str.charAt(j));
                        }
                    }
                    else {//B라면
                        if(str.charAt(j)=='B') {
                            st.pop();
                        }
                        else{
                            st.push(str.charAt(j));
                        }
                    }
                }
            }
            if(st.isEmpty()){
                answer++;
            }
        }
        //답 출력
        System.out.println(answer);



    }
}