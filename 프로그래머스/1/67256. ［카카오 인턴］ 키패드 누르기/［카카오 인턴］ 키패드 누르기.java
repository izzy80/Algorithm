import java.util.*;
    class Solution {
         static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};
        public String solution(int[] numbers, String hand) {
            String answer = "";
            String[][] keypad = {{"1","2","3"},{"4","5","6"},{"7","8","9"},{"*","0","#"}};
            String left = "*";
            String right = "#";
            StringBuilder sb = new StringBuilder();
            for(int i=0; i < numbers.length; i++){
                String number = Integer.toString(numbers[i]);
                if(number.equals("1") || number.equals("4") || number.equals("7")){
                    sb.append("L");
                    left = number;
                }
                else if(number.equals("3") || number.equals("6") || number.equals("9")){
                    sb.append("R");
                    right = number;
                }
                else{
                    int leftDistance = BFS(left, number, keypad);
                    int rightDistance = BFS(right, number,keypad);
                    // System.out.println(leftDistance+", "+rightDistance);
                    if(leftDistance == rightDistance){
                         if(hand.equals("right")){
                            sb.append("R");
                            right = number;
                        }
                        else{
                            sb.append("L");
                            left = number;
                        }
                    }
                    else if(leftDistance > rightDistance){
                        sb.append("R");
                        right = number;
                    }
                    else{
                        sb.append("L");
                        left = number;
                    }
                }
            }

            return sb.toString();
        }

        static public int BFS(String start, String end, String[][] keypad){
            Queue<int[]> q = new LinkedList<>();
            int[][] visited = new int[4][3];

            for(int i=0; i < 4; i++){
                for(int j = 0; j < 3; j++){
                    if(keypad[i][j].equals(start)){
                        q.add(new int[]{i,j});
                        visited[i][j] = 1;
                    }
                }
            }

            while(!q.isEmpty()){
                int[] tmp = q.poll();
                int cr = tmp[0];
                int cc = tmp[1];
                if(keypad[cr][cc].equals(end)) return visited[cr][cc]-1;

                for(int m=0; m <4; m++){
                    int nr = cr + mover[m];
                    int nc = cc + movec[m];

                    if(nr < 0 || nr >= 4 || nc < 0 || nc >= 3) continue;
                    if(visited[nr][nc] != 0) continue;
                    q.add(new int[]{nr,nc});
                    visited[nr][nc] = visited[cr][cc]+1;
                }
            }
            return 0;
        }
    }