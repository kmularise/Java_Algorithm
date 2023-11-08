import java.util.*;
/**
 * DP
 * 시간 복잡도 : n
 */

public class Main {
    private static int n;
    private static int dp[][] = new int[10001][4];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> candidates = new ArrayList<>();
        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;
        for (int i = 2; i <= 10000 ; i++) {
            if (i - 1 >= 1) {
                dp[i][1] = dp[i - 1][1];
            }
            else {
                dp[i][1] = 0;
            }
            if (i - 2 >= 1) {
                dp[i][2] = dp[i - 2][2] + dp[i - 2][1];
            }
            else {
                dp[i][2] = 0;
            }
            if (i - 3 >= 1) {
                dp[i][3] = dp[i - 3][3] + dp[i - 3][2] + dp[i - 3][1];
            } else {
                dp[i][3] = 0;
            }
            if (i == 2 || i == 3) {
                dp[i][i] = 1;
            }
        }
        n = sc.nextInt();
        for (int i = 0 ; i < n ; i++) {
            int t = sc.nextInt();
            System.out.println(dp[t][1] + dp[t][2] + dp[t][3]);
        }
        
    }
}

