import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] ches;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ches = new char[N][M];
        for(int i=0; i< N; i++){
            String str = br.readLine();
            for(int j=0; j < M; j++){
                ches[i][j] = str.charAt(j);
            }
        }

        //정답 체스판 만들기
        char[][] correctW = new char[8][8]; //첫 번째 칸이 W시작
        char[][] correctB = new char[8][8]; //천 번째 칸이 B시작

        for(int i=0; i< 8;i++){
            for(int j =0; j< 8; j++){
                if(i%2==0){ //i가 짝수이면
                    if(j%2==0){//j가 짝수일때만
                        correctB[i][j] = 'B';
                        correctW[i][j] = 'W';
                    }
                    else{
                        correctB[i][j] = 'W';
                        correctW[i][j] = 'B';
                    }

                }
                else{//i가 홀수이면
                    if(j%2==0){
                        correctB[i][j] = 'W';
                        correctW[i][j] = 'B';
                    }
                    else{//j가 홀수일때만
                        correctB[i][j] = 'B';
                        correctW[i][j] = 'W';
                    }
                }
            }
        }



        //탐색
        int min = Integer.MAX_VALUE;
        for(int i=0; i<= N-8; i++){
            for(int j=0; j<=M-8; j++){
                int Wcnt = checkWBCnt(correctW, i, j);
                int Bcnt = checkWBCnt(correctB, i, j);

                int cnt = Integer.min(Wcnt, Bcnt);

                if(min > cnt){
                    min = cnt;
                }
            }
        }


        System.out.println(min);
    }//main

    private static int checkWBCnt(char[][] correct, int i, int j) {
        //8*8 체스판 1개
        int diffCnt = 0;

        for(int k = i; k < i+8; k++){
            for(int l = j; l < j+8; l++){
                if(ches[k][l] != correct[k-i][l-j]){
                    diffCnt++;
                }
            }
        }

        return diffCnt;

    }
}