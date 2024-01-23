import java.io.*;
import java.util.*;
//dp 시간복잡도 n * k
//점화식 생각하기가 어려움 ㅜㅜ
public class Main {
    private static int[] dp;
    private static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cmd1 = br.readLine().split(" ");
        int n = Integer.parseInt(cmd1[0]);
        int k = Integer.parseInt(cmd1[1]);
        dp = new int[100_001];
        for (int i = 0 ; i < n ; i ++) {
            int number = Integer.parseInt(br.readLine());
            numbers.add(number);
        }
        dp[0] = 1; 
        for (int i = 1 ; i <= n ; i++) {
            for (int j = numbers.get(i - 1) ; j <= k ; j++) {
                dp[j] += dp[j - numbers.get(i - 1)];
            }
        }
        System.out.println(dp[k]);
    }
}
