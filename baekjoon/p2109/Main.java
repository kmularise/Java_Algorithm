import java.util.*;
//시간 복잡도 nlogn - 전형적인 그리디 문제
public class Main {
    private static List<List<Integer>> sessions = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int day = 0;
        for (int i = 0 ; i < n ; i++) {
            int p = sc.nextInt();
            int d = sc.nextInt();
            sessions.add(List.of(p, d));
            day = Math.max(day, d);
        }
        sessions.sort((x, y) -> Integer.compare(-x.get(1), -y.get(1)));
        Queue<Integer> queue = new PriorityQueue<>((x, y) -> Integer.compare(-x, -y));
        int index = 0;
        int answer = 0;
        for (int i = day ; i > 0 ; i--) {
            while (index < n && sessions.get(index).get(1) >= i) {
                queue.add(sessions.get(index).get(0));
                index++;
            }
            if (!queue.isEmpty()) {
                int pay = queue.poll();
                answer += pay;
            }
        }
        System.out.println(answer);
    }
}