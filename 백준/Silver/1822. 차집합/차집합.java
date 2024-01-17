import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int num_A = Integer.parseInt(st.nextToken());
        int num_B = Integer.parseInt(st.nextToken());

        TreeSet<Integer> A = new TreeSet<>();
        TreeSet<Integer> B = new TreeSet<>();

        TreeSet<Integer> result = new TreeSet<>();

        st = new StringTokenizer(br.readLine());

        for(int i=0; i< num_A; i++){
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i< num_B; i++){
            B.add(Integer.parseInt(st.nextToken()));
        }

        Iterator it = A.iterator();

        while(it.hasNext()){
            Integer tmp = (Integer)it.next();
            if(!B.contains(tmp))
                result.add(tmp);
        }

        //출력
        int size = result.size();
        System.out.println(size);


        StringBuilder sb = new StringBuilder();

        if(size != 0){
            it = result.iterator();
            while(it.hasNext()){
                sb.append(it.next()).append(" ");
            }

            System.out.println(sb.toString());
        }






    }
}