import java.util.*;

//1:30 - 1:49
public class Main {
    private static List<List<Integer>> cows = new ArrayList<>();
    public static void main(String[] args) {
        //울타리
        //스케줄링이랑 유사한거 같다.
        // 언제 받든 검문 시간은 동일하다.
        // 그러면 기다리는 시간을 최소화해야 된다.
        // 기다리는 시간을 최소화하려면 현재 받을 수 있는 소 중에서 가장 검문시간이
        // 짧은 소를 받으면 되지 않을까...
        // 도착시간대로 정렬뒤 우선순위큐 이용하는 방식

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int arrive = sc.nextInt();
            int amount = sc.nextInt();
            cows.add(List.of(arrive, amount));
        }
        cows.sort((x, y) -> Integer.compare(x.get(0), y.get(0)));
        Queue<Integer> pq = new PriorityQueue<Integer>(Integer::compare);
        int day = 1;
        int index = 0;
        while (index < n || !pq.isEmpty()) {
            while (index < n && cows.get(index).get(0) <= day) {
                pq.add(cows.get(index).get(1));
                index++;
            }
            //처리할 소가 있을 때
            if (!pq.isEmpty()){
                day += pq.poll(); 
            } else {
                day = cows.get(index).get(0);
            }

            //처리할 소가 없을 때
        }
        System.out.println(day);
    }
}