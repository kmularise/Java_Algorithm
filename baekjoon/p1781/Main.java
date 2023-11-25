//n log n
// while 조건 - day 자연수 주의
// 거꾸로 하기
import java.util.*;
public class Main {
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Long>> cups = new ArrayList<>(); 
        //기본 틀
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            cups.add(List.of(sc.nextLong(), sc.nextLong()));
        }
        cups.sort((x, y) -> Long.compare(-x.get(0), -y.get(0)));
        int idx = 0;
        long answer = 0;
        long day = n;
        Queue<Long> queue = new PriorityQueue<>();
        while (day > 0) {
            while (idx < n && cups.get(idx).get(0) >= day) {
                queue.add(-cups.get(idx).get(1));
                idx++;
            }
            if (!queue.isEmpty()) {
                answer += -queue.poll();
            }
            day--;
        }
        System.out.println(answer);
    }
}