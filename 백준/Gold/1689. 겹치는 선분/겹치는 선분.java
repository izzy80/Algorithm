import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final int START_TYPE = 1;
    
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
        List<Spot> spots = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
        	String[] tmp = sc.nextLine().split(" ");
            int start = Integer.parseInt(tmp[0]);
            int end = Integer.parseInt(tmp[1]);
            spots.add(new Spot(start, 1));
            spots.add(new Spot(end, 0));
        }
        Collections.sort(spots);

        int answer = 0;
        int conflictCount = 0;
        for (Spot spot : spots) {
            if (spot.type == START_TYPE) {
                conflictCount++;
                answer = Math.max(answer, conflictCount);
            } else {
                conflictCount--;
            }
        }

        System.out.println(answer);
    }
}

class Spot implements Comparable<Spot> {
    int point;
    int type;

    public Spot(final int point, final int type) {
        this.point = point;
        this.type = type;
    }

    @Override
    public int compareTo(final Spot o) {
        if (point == o.point) {
            return Integer.compare(type, o.type);
        }
        return Integer.compare(point, o.point);
    }
}