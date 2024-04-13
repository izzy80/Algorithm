import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mapN = 3;

        while(true){
            String str = br.readLine();
            if(str.equals("end")) break; //end가 나오면 break
            char[][] map = new char[mapN][mapN];
            int idx = 2; //2씩 증가
            int xCnt = 0;
            int oCnt = 0;
            int dotCnt = 0;
            for(int i=0; i < mapN; i++){
                for(int j=0; j < mapN; j++){
                    char c = str.charAt(i+j+(i*idx));
                    map[i][j] = c;
                    if(c == 'X') xCnt++;
                    if(c == 'O') oCnt++;
                    if(c == '.') dotCnt++;
                }
            }
//            System.out.println(Arrays.deepToString(map));

            //check
            int totalCnt = xCnt+oCnt;
            String answer = "valid";
            if ((xCnt != oCnt + 1 && xCnt != oCnt) || xCnt < oCnt) {
                System.out.println("invalid");
                continue;
            }
            //빙고
            boolean xWin = checkWin(map, 'X');
            boolean oWin = checkWin(map, 'O');

            if (xWin && oWin) {
                System.out.println("invalid");
            } else if (xWin && xCnt == oCnt + 1) {
                System.out.println("valid");
            } else if (oWin && xCnt == oCnt) {
                System.out.println("valid");
            } else if (!xWin && !oWin && xCnt + oCnt == 9) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }
        }
    }

    private static boolean checkWin(char[][] map, char player) {
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == player && map[i][1] == player && map[i][2] == player) return true;
            if (map[0][i] == player && map[1][i] == player && map[2][i] == player) return true;
        }
        if (map[0][0] == player && map[1][1] == player && map[2][2] == player) return true;
        if (map[0][2] == player && map[1][1] == player && map[2][0] == player) return true;

        return false;
    }
}