import java.util.*;

public class File {
    String head;
    String number;
    String tail;
    int idx;
    
    public File(String head, String number, String tail, int idx){
        this.head = head;
        this.number = number;
        this.tail = tail;
        this.idx = idx;
    }
}

class Solution {
    public String[] solution(String[] files) {
       int N = files.length;
            String[] answer = new String[N];
            File[] file = new File[N];

            int idx = 0;
            for (String f : files) {
                boolean numflag = false;
                StringBuilder head = new StringBuilder();
                StringBuilder number = new StringBuilder();
                StringBuilder tail = new StringBuilder();

                for (int i = 0; i < f.length(); i++) {
                    char c = f.charAt(i);
                    if (c >= '0' && c <= '9') {
                        number.append(c);
                        numflag = true;
                    } else {
                        if (!numflag) head.append(c);
                        else {
                            tail.append(f.substring(i));
                            break;
                        }
                    }
                }
                file[idx] = new File(head.toString(), number.toString(), tail.toString(),idx);
                idx++;
            }
            //정렬
            Arrays.sort(file, (o1,o2) -> {
                if(o1.head.equalsIgnoreCase(o2.head)){
                    if(Integer.parseInt(o1.number) == Integer.parseInt(o2.number)){
                        return o1.idx - o2.idx;
                    }
                    return Integer.parseInt(o1.number) - Integer.parseInt(o2.number);
                }
                return o1.head.toUpperCase().compareTo(o2.head.toUpperCase());
            });
            //answer 만들기
            StringBuilder sb;
            for(int i=0; i < N; i++){
                sb = new StringBuilder();
                answer[i] = sb.append(file[i].head).append(file[i].number).append(file[i].tail).toString();
            }
            return answer;
    }
}