import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
                        String str = sc.next(); // 0011
            int n = str.length();
            int cnt=0;
            int[] cho = new int[n]; 
            int[] arr = new int[n];
            for(int i=0;i<n;i++) {
                arr[i] = (int)str.charAt(i)-'0';
            }
            //System.out.println(Arrays.toString(arr));
             
         
            //변환
            for(int i=0;i<n;i++) {
                if(arr[i]!= cho[i]) {
                    for(int j=i;j<n;j++) {
                        if(cho[j] == 1)
                            cho[j] = 0;
                        else {
                            cho[j] = 1;
                        }
                    } cnt++;
                }
            }
            System.out.println("#"+(test_case)+" " +cnt);
             
        }
    }
}