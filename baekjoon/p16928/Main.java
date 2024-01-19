//15:09 15:28
//BFS, 시간 복잡도 n *6 결국 n
import java.util.*;
public class Main {
    private static int[] path = new int[101];
    private static int[] dp = new int[101];
    public static void main(String[] args) {
        //기본 틀
        //
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1 ; i <= 100 ; i++) {
            path[i] = i;
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0 ; i < n ; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            path[x] = y;
        }
        for (int i = 0 ; i < m ; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            path[u] = v;
        }
        int start = 1;
        dp[start] = 0;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(start);
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for (int dice = 1 ; dice <= 6 ; dice++) {
                if (curr + dice > 100) continue;
                int next = path[curr + dice];
                if (next > 100) continue;
                if (dp[next] > dp[curr] + 1) {
                    dp[next] = dp[curr] + 1;
                    queue.add(next);
                }
            }
        }
        System.out.println(dp[100]);
    }
}
