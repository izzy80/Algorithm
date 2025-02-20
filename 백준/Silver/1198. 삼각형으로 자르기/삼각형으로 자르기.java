import java.util.*;
import java.io.*;

public class Main {
    static class Grid {
        int x;
        int y;

        public Grid(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Grid[] g = new Grid[N];
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            g[i] = new Grid(x,y);
        }

        double answer = Double.MIN_VALUE;

        for(int i=0; i < N; i++){
            for(int j=i+1; j < N; j++){
                for(int k=j+1; k < N; k++){
                    double max = cal(g[i], g[j], g[k]);
                    answer = Math.max(max, answer);
                }
            }
        }

        System.out.println(answer);


    }

    static public double cal(Grid a, Grid b, Grid c){
        double extent = Math.abs((a.x * (b.y - c.y)+b.x * (c.y - a.y)+c.x * (a.y - b.y))/2.0);
        return extent;
    }
}