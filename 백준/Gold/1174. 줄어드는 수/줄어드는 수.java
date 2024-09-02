import java.io.*;
import java.util.*;

public class Main {
    static List<Long> list;
    static int[] arr = {9,8,7,6,5,4,3,2,1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        DFS(0,0);

        Collections.sort(list);

        if(N > list.size()) {
            System.out.println(-1);
        }
        else{
            System.out.println(list.get(N-1));
        }



    }

    static  public void DFS(long num, int idx){
        if(idx  == 10) {
            if(!list.contains(num)){
                list.add(num);
            }
            return;
        }
        //해당 인덱스 선택 안 하고 넘어감
        DFS(num, idx+1);
        //해당 인덱스 선택한 경우 num에 더해줌
        DFS((num*10)+arr[idx], idx+1);

    }
}