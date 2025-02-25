
class Solution {
    static int opsMin,opsSec, opeMin, opeSec;
    public static boolean isOpening(int min, int sec){
        if(min == opsMin && sec < opsSec) return false;
        if(min == opeMin && sec > opeSec) return false;
        return true;
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

            String[] tmp = pos.split(":");
            int min = Integer.parseInt(tmp[0]);
            int sec = Integer.parseInt(tmp[1]);

            String[] end = video_len.split(":");
            int endMin = Integer.parseInt(end[0]);
            int endSec = Integer.parseInt(end[1]);

            String[] ops = op_start.split(":");
            opsMin = Integer.parseInt(ops[0]);
            opsSec = Integer.parseInt(ops[1]);

            String[] ope = op_end.split(":");
            opeMin = Integer.parseInt(ope[0]);
            opeSec = Integer.parseInt(ope[1]);


            for(int i=0; i < commands.length; i++){
                if(min >= opsMin && min <= opeMin){
                    if(isOpening(min, sec)){
                        min = opeMin;
                        sec = opeSec;
                    }
                }

                switch(commands[i]){
                    case "prev":
                        sec -= 10;
                        break;
                    case "next":
                        sec += 10;
                        break;
                }

                //시간 맞추기
                if(sec < 0){
                    if(min == 0){
                        sec = 0; //처음으로 초기화
                    }
                    else if(min > 0){
                        min--;
                        sec += 60;
                    }
                }
                if(sec > 59){
                    min++;
                    sec -= 60;

                    if(min == endMin && sec >= endSec || min > endMin){
                        min = endMin;
                        sec = endSec;
                    }
                }
                   if(min == endMin && sec >= endSec || min > endMin){
                    min = endMin;
                    sec = endSec;
                }
            }
            if(min >= opsMin && min <= opeMin){
                if(isOpening(min, sec)){
                    min = opeMin;
                    sec = opeSec;
                }
            }

            StringBuilder sb = new StringBuilder();
            String m = Integer.toString(min);
            String s = Integer.toString(sec);
            if(min < 10) m = "0"+m;
            if(sec < 10) s = "0"+s;

            answer = sb.append(m).append(":").append(s).toString();

            return answer;
    }
}