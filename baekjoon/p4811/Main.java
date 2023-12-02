import java.util.*;
public class Main {
    private static long[][] dp = new long[31][70];

    public static long setDp(int n, int half) {
        if (dp[n][half] != 0) {
            return dp[n][half];
        }
        if (n == 0) {
            dp[n][half] = 1;
            return 1;
        }
        if (half == 0) {
            if (dp[n][half] == 0) {
                dp[n][half] = setDp(n - 1, half + 1);
                return dp[n][half];
            }
            return dp[n][half];
        }
        dp[n][half] = setDp(n, half - 1) + setDp(n - 1, half + 1);
        return dp[n][half];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break ;
            }
            System.out.println(setDp(n, 0));
        }
    }
}