import java.util.*;
import java.io.*;
//시간복잡도 n DP 놓친 부분이 여러 군데 있었다.
//우선 Integer.MAX_VALUE 오버 플로우를 고려하지 않았다.

public class Main {
    private static List<Integer> numbers = new ArrayList<>();
    private static int[] dp = new int[10001];
    public static void main(String[] args) throws Exception {
        //기본 틀
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] cmds = br.readLine().split(" ");
        int n = Integer.parseInt(cmds[0]);
        int k = Integer.parseInt(cmds[1]);
        //
        for (int i = 0 ; i < n ; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp <= k) {
                numbers.add(temp);
            }
        }
        for (int i = 0 ; i <= k ; i++) {
            dp[i] = 100_000;
        }
        for (int number : numbers) {
            dp[number] = 1;
        }
        for (int i = 1 ; i <= k ; i++) {
            for (int number : numbers) {
                if (i - number > 0 ) {
                    dp[i] = Math.min(dp[i], dp[i - number] + 1);
                }
            }
        }
        System.out.println(dp[k] >= 100_000 ? -1 : dp[k]);
    }
}