import java.util.*;
import java.io.*;

/**
 * 가장 적은 가격의 합을 출력
 */
public class Main {
    static int N;
    static int[] alpha = new int[26];
    static int[] check_alpha = new int[26];
    static int answer = Integer.MAX_VALUE;
    static Book[] books;

    static public class Book {
        int price;
        String title;

        public Book(int price, String title){
            this.price = price;
            this.title = title;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String goalWord = br.readLine(); //만들기 원하는 문자
        for(int i=0; i<goalWord.length(); i++){
            int c = goalWord.charAt(i)-'A';
            alpha[c]++;
        }

        N = Integer.parseInt(br.readLine()); //전공책의 개수

        books = new Book[N];
        StringTokenizer st;
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            String title = st.nextToken();
            books[i] = new Book(price, title);
        }

        dfs(0,0);



        System.out.println(answer == Integer.MAX_VALUE? -1 : answer);

    }
    public static boolean check(){
        for(int i=0; i < 26; i++){
            if(alpha[i] > check_alpha[i]){
                return false;
            }
        }
        return true;
    }

    public static void dfs(int index, int curPrice){
        //index : 전공책
        if(index == N){
            //전공책을 다 둘러봤으면
            if(check()){
                answer = Math.min(answer, curPrice);
            }
            return;
        }

        for(int i=0; i<books[index].title.length(); i++){
            int idx = books[index].title.charAt(i)-'A';
            check_alpha[idx]++;
        }
        dfs(index+1, curPrice+books[index].price);
        for(int i=0; i<books[index].title.length(); i++){
            int idx = books[index].title.charAt(i)-'A';
            check_alpha[idx]--;
        }
        dfs(index+1, curPrice);
    }
}