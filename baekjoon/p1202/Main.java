import java.util.*;

class Point implements Comparable<Point>{
    int key;
    int value;
    
    Point(int key, int value) {
        this.key = key;
        this.value =value;
    }

    @Override
    public int compareTo(Point another) {
        return this.value <= another.value ? 1: -1; 
    }

    public String toString() {
        return "(" + Integer.toString(this.key) + "," + Integer.toString(this.value) + ")";
    } 
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> bags = new ArrayList<>();
        //기본 틀
        int n = sc.nextInt(); int k = sc.nextInt();
        List<Point> jewerlys = new ArrayList<>();

        for (int i = 0 ; i < n ; i++) {
            Point pair = new Point(sc.nextInt(), sc.nextInt());
            jewerlys.add(pair);
        }
        jewerlys.sort((x, y) -> (x.key - y.key));
        for (int i = 0 ; i < k ; i++) {
            bags.add(sc.nextInt());
        }
        bags.sort((x, y) -> (x - y));
        long answer = 0;
        int j = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Integer bag : bags) {
            while (j < n && bag >= jewerlys.get(j).key) {
                queue.offer(-jewerlys.get(j).value);
                j++;
            }
            if (!queue.isEmpty()) {
                answer += (long)-queue.poll();
            }
        }
        System.out.println(answer);
    }
}