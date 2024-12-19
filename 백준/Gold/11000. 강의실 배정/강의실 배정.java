import java.util.*;
import java.io.*;

public class Main {
    static class Lecture {
        int s;
        int e;

        public Lecture(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[N];
        StringTokenizer st;
        for(int i=0; i <N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(s,e);
        }


        //정렬
        //끝 시간 순으로 정렬
        Arrays.sort(lectures, (o1,o2) -> {
            if(o1.s == o2.s){
                return o1.e - o2.e;
            }
            return o1.s - o2.s;
        });

        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lectures[0].e);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= lectures[i].s) {
                pq.poll();
            }
            pq.offer(lectures[i].e);
        }

        //출력
        System.out.println(pq.size());



    }
}