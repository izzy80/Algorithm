import java.util.*;
import java.io.*;

class Seat{
    int r;
    int c;
    int emptyCnt;
    int friendCnt;

    public Seat(int r, int c, int emptyCnt, int friendCnt) {
        this.r = r;
        this.c = c;
        this.emptyCnt = emptyCnt;
        this.friendCnt = friendCnt;
    }
}

public class Main {
    static int N, studentN;
    static int[][] map;
    static HashMap<Integer, int[]> hm;
    static int[] mover = {1,0,-1,0};
    static int[] movec = {0,1,0,-1};
    static int score = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //교실 크기
        studentN = N*N;
        map = new int[N][N];

        hm = new HashMap<>();
        for(int i=0; i < studentN; i++){
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken()); //학생 번호
            int[] likes = new int[4];//좋아하는 친구
            for(int j=0; j < 4; j++){
                likes[j] = Integer.parseInt(st.nextToken());
            }
            //1. 좋아하는 친구 저장
            hm.put(number, likes);

            //2. 학생 자리 앉히기
            putStudentSeat(number);
        }

        //3 만족도 구하기
        getScore();
        System.out.println(score);
    }

    private static void getScore() {
        for(int i = 0; i < N; i++){
            for(int j =0; j < N; j++){
                int[] like = hm.get(map[i][j]);//좋아하는 친구
                int cnt = 0;
                for(int m = 0; m < 4; m++){
                    int nr = i+mover[m];
                    int nc = j+movec[m];

                    if(nr <0 || nr >= N || nc <0 || nc >= N) continue;
                    for(int k=0; k < 4; k++){
                        if(like[k] == map[nr][nc]) cnt++;
                    }
                }

                switch(cnt){
                    case 1: score+=1;break;
                    case 2: score+=10;break;
                    case 3: score+=100;break;
                    case 4: score+=1000;break;
                }
            }
        }


    }

    /*
    1. 좋아하는 학생이 많이 인접한 곳
    2. 비어있는 칸이 많은 곳
    3. 행의 번호가 가장 작은 칸-> 열의 번호가 가장 작은 칸
     */
    private static void putStudentSeat(int number) {
        int[] likes = hm.get(number); //좋아하는 친구
        ArrayList<Seat> seats = new ArrayList<>(); //학생이 앉을 수 있는 자리 (학생 마다 업데이트)

        for(int i=0; i < N; i++){
            for(int j=0; j < N; j++){
                int friendCnt = 0;
                int emptyCnt = 0;

                //주변 위치 파악
                for(int m = 0; m < 4; m++){
                    int nr = i+mover[m];
                    int nc = j+movec[m];

                    if(nr <0 || nr >= N || nc < 0 || nc >= N) continue;
                    if(map[nr][nc] == 0) emptyCnt++;
                    else{
                        for(int k = 0; k < 4; k++){
                            if(map[nr][nc] == likes[k]) friendCnt++;
                        }
                    }
                }
                seats.add(new Seat(i,j,emptyCnt, friendCnt));
            }
        }

        // 정렬
        Collections.sort(seats, (o1, o2) -> {
            if(o1.friendCnt == o2.friendCnt){
                if (o1.emptyCnt == o2.emptyCnt) {   //2순위 : 비어있는 칸이 많은 칸
                    if (o1.r == o2.r) {             //3순위 : 행의 번호가 가장 작은 칸
                        return o1.c - o2.c;         //4순위 : 열의 번호가 가장 작은 칸
                    }
                    return o1.r - o2.r;
                }
                return o2.emptyCnt - o1.emptyCnt;
            }
            return o2.friendCnt - o1.friendCnt; //좋아하는 친구가 많은 곳
        });

        for(Seat s : seats){
            if(map[s.r][s.c] != 0) continue;
            map[s.r][s.c] = number;
            return;
        }


    }
}