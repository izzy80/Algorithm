import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[][] alpha = new int[str.length()+1][26]; //[주어진 문자열의 인덱스][해당 알파벳의 인덱스]


        //2. str에 있는 문자가 str에 몇 개 있는지 문자 탐색
        for(int i = 1;i<= str.length();i++) {
            //현재 탐색할 문자 
            int searchChar = str.charAt(i-1)-'a';

            //알파벳 a부터 z까지 반복
            for(int j = 0; j < 26; j++) {
                //현재 탐색중인 문자보다 한단계 앞인 문자의 값(=이전 값)
                int beforeValue = alpha[i-1][j];
                //알파벳과 탐색 중인 문자가 같으면 이전값 + 1,다르면 이전값으로 넣음
                alpha[i][j] = ( j == searchChar ? beforeValue+1 : beforeValue);
            }
        }
        
        // 3. 실제 들어오는 값에 대한 누적합 구하기 
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int findIdx = st.nextToken().charAt(0)-'a'; //찾으려는 문자의 인덱스
            int start = Integer.parseInt(st.nextToken())+1; //시작점
            int end = Integer.parseInt(st.nextToken())+1; //끝점

            //가장 끝점의 누적합 - 찾으려는 범위
            sb.append(alpha[end][findIdx]-alpha[start-1][findIdx]).append("\n");
        }

        //4. print
        System.out.println(sb);

    }
}