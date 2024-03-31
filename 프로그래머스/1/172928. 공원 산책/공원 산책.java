class Solution {
    public int[] solution(String[] park, String[] routes) {
         int[] answer = new int[2];
            int N = park.length;
            int M = park[0].length();
            char[][] map = new char[N][M];
            int startr = 0;//시작점
            int startc = 0;
            for(int i=0; i < N; i++){
                String tmp = park[i];
                for(int j=0; j< M; j++){
                    char c = tmp.charAt(j);
                    if(c == 'S'){//시작점 저장
                        startr = i;
                        startc = j;
                    }
                    map[i][j] = c;
                }
            }

            //routes
            int R = routes.length;
            int r = startr;
            int c = startc;
            int defaultr = startr;
            int defaultc = startc;
            for(int i = 0; i < R; i++){//경로 for문
                String[] tmp = routes[i].split(" ");

                String dir = tmp[0]; //방향
                int step = Integer.parseInt(tmp[1]); //몇 걸음

                int mr = 0; //어디로 이동할지
                int mc = 0;
                switch (dir){
                    case "N": //북 (-1,0)
                        mr = -1;
                        mc = 0;
                        break;
                    case "S"://남(1,0)
                        mr = 1;
                        mc = 0;
                        break;
                    case "W"://서(0,-1)
                        mr = 0;
                        mc = -1;
                        break;
                    case "E"://동(0,1)
                        mr = 0;
                        mc = 1;
                        break;
                }
//                System.out.println("----------mr = "+ mr + ", mc = "+mc+" --------------");
                //step계산

                for(int m =1 ; m<=step; m++){
//                    System.out.println("r = "+r+",c = "+c);
                    int nr = r + mr;
                    int nc = c + mc;
//                    System.out.println("nr = "+ nr + ", nc = "+nc);
                    if(nr <0 || nr >= N || nc < 0 || nc >= M) {
//                        System.out.println("공원 밖으로 나감");
                        //그럼 나가기 전에 초기화
                        r = defaultr;
                        c = defaultc;
                        break;
                    }
                    if(map[nr][nc] == 'X') {
                        //그럼 나가기 전에 초기화
                        r = defaultr;
                        c = defaultc;
//                        System.out.println("지나갈 수 있는 곳이 아님");
                        break;
                    }
                    //여기까지 오면 저 명령을 통과한 것
                    r = nr;
                    c = nc;
                }
                defaultr = r;
                defaultc = c;
            }
            answer[0] = r;
            answer[1] = c;
            return answer;
    }
}