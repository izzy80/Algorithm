import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[][] keyboard = {{"q","w","e","r","t","y","u","i","o","p"},
                {"a","s","d","f","g","h","j","k","l"},
                {"z","x","c","v","b","n","m"}};
        String sL = st.nextToken(); //자음만 가능
        int sLr = 0;  //현재 손가락의 위치
        int sLc = 0;
        String sR = st.nextToken();//모음만 가능
        int sRr = 0;
        int sRc = 0;

        String korea = "yuiophjklbnm";

        for(int i=0; i < keyboard.length; i++){
            for(int j =0; j < keyboard[i].length; j++){
                if(sL.equals(keyboard[i][j])){
                   sLr = i;
                   sLc = j;
                }
                if(sR.equals(keyboard[i][j])){
                    sRr = i;
                    sRc = j;
                }
            }
        }


        String str = br.readLine();

        int time =0;
        for(int i=0; i< str.length(); i++){
            String s = String.valueOf(str.charAt(i));
            int r = 0;
            int c = 0;
            for(int j=0; j < keyboard.length; j++){
                for(int k =0; k < keyboard[j].length; k++){
                    if(s.equals(keyboard[j][k])){
                        r = j;
                        c = k;
                    }
                }
            }

            if(korea.contains(s)){
                //모음이면 -> 오른손
                time+= Math.abs(r-sRr)+Math.abs(c-sRc);//시간 더해주기
                sRr = r; //현재 위치로 변경
                sRc = c;
            }
            else{//자음이면 -> 왼손
                time+= Math.abs(r-sLr)+Math.abs(c-sLc);//시간 더해주기
                sLr = r; //현재 위치로 변경
                sLc = c;
            }
        }

        //문자 하나 누르는 것당 1초가 걸리므로 문자열 길이도 더해준다.
        System.out.println(time+str.length());
    }
}