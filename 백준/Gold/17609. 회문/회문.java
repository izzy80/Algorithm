import java.io.*;

public class Main {
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i < N; i++){
            str = br.readLine();
            System.out.println(isPalindrome(0, str.length()-1, 0));
        }
    }
    public static int isPalindrome(int start, int end, int delCnt){
        if(delCnt >= 2){//삭제된 문자열이 2개라는 것 == 회문이 불가능
            return 2;
        }
        while(start < end){
            if(str.charAt(start) == str.charAt(end)){//같으면 start, end 하나씩 이동
                start++;
                end--;
            }
            else{//같지 않다면
                //1. start 뒤로 이동
                int resultFirst = isPalindrome(start+1, end, delCnt+1);
                //2. end 앞으로 이동
                int resultSecond = isPalindrome(start, end-1, delCnt+1);
                int result = Math.min(resultFirst, resultSecond);
                //회문일 경우 0 이 반환되고, 유사회문이라면 1이 나옴
                return result;
            }
        }
        return delCnt; //그냥 회문이라면 else문을 타고 가지 않고 바로 0인 결과가 나옴 
    }
}