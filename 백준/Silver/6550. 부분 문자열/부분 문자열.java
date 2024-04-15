import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){//tc
            String str = br.readLine();
            if(str == null) break;
            String[] words = str.split(" ");

            int idx = 0; //words[1]
            String answer = "Yes";
            for(int i=0; i < words[0].length(); i++){
                while(true){
                    if(idx >= words[1].length()){
                        answer = "No";
                        break;
                    }
                    if(words[0].charAt(i) == words[1].charAt(idx)) {//
                        idx++;
                        break;
                    }
                    else{
                        idx++;
                    }
                }
            }
            System.out.println(answer);



        }

    }
}