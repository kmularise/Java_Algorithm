import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws Exception {
        //기본 틀
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Double> queue = new PriorityQueue<>();
        for (int i = 0 ; i < n ; i++) {
            double target = Double.parseDouble(br.readLine());
            if (queue.size() != 7) {
                queue.offer(-target);
            } else {
                queue.offer(-target);
                queue.poll();
            }
        }
        Deque<Double> dq = new LinkedList<>();
        
        while (!queue.isEmpty()) {
            double answer = queue.poll();
            dq.addFirst(-answer);
        }
        while (!dq.isEmpty()) {
            double answer = dq.poll();
            System.out.format("%.3f", answer);
            System.out.println();
        }
    }
}