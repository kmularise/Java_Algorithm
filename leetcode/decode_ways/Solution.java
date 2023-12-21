// https://leetcode.com/problems/decode-ways/
// DP 시간 복잡도 n 
// dfs로 풀다가 시간초과가 나버렸다. 이정도는 시간초과날 것을 예상했어야 했다..
class Solution {
    private int[] dp;
    int getOneCount(int start, String s) {
        if (0 < s.charAt(start) - '0' && s.charAt(start) - '0' < 10) {
            return 1;
        }
        return 0;
    }

    int getTwoCount(int start, String s) {
        int compared = Integer.parseInt(s.substring(start, start + 2));
        if (10 <= compared && compared <= 26) {
            return 1;
        }
        return 0;
    }

    public int numDecodings(String s) {
        dp = new int[s.length()];
        dp[0] = getOneCount(0, s);
        if (s.length() == 1) {
            return dp[0];
        }
        dp[1] = dp[0] * getOneCount(1, s) + getTwoCount(0, s);
        for (int i = 2 ; i < s.length() ; i++) {
            dp[i] = dp[i - 1] * getOneCount(i, s) + dp[i - 2] * getTwoCount(i - 1, s);
        }
        return dp[s.length() - 1];
    }
}