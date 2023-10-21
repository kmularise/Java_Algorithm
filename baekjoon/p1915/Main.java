import java.util.*;

/**
 * DP 풀이
 * 시간복잡도 : n * m
 */

public class Main {
    private static int dp[][] = new int[1001][1001];
    private static char graph[][] = new char[1001][1001];
    private static int n;
    private static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int y = 0 ; y < n ; y++) {
            String temp = sc.next();
            for (int x = 0; x < m; x++) {
                graph[y][x] = temp.charAt(x);
            }
        }
        int maximum = 0;
        for (int y = 1 ; y <= n ; y++) {
            for (int x = 1; x <= m; x++) {
                if (graph[y - 1][x - 1] == '1') {
                    dp[y][x] = Math.min(Math.min(dp[y - 1][x - 1], dp[y -1][x]), dp[y][x -1]) + 1;
                    maximum = Math.max(maximum, dp[y][x]);
                }
            }
        }
        System.out.println(maximum * maximum);
    }
}