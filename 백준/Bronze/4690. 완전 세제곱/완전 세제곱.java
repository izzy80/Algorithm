import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        for(int i=1; i <= 100; i++){
            for(int j=2; j <= 100; j++){
                for(int k = j+1; k <= 100; k++){
                    for(int l = k+1; l <= 100; l++){
                        if(solve(i,j,k,l)){
                            sb.append("Cube = ").append(i).append(", Triple = (")
                                    .append(j).append(",")
                                    .append(k).append(",")
                                    .append(l).append(")").append("\n");

                        }
                    }
                }
            }
        }
        System.out.println(sb.toString());


    }

    public static boolean solve(int i, int j, int k, int l){
        int a = i*i*i;
        int b = j*j*j;
        int c = k*k*k;
        int d = l*l*l;

        int sum = b+c+d;
        return a == sum;
    }
}