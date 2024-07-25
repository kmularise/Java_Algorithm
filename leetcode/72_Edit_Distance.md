# 72. Edit Distance
* 문제 : https://leetcode.com/problems/edit-distance/description/
* LCS와 유사한 느낌이다.
* DP, bottom up 방식의 풀이이다. 원래 풀던 방식의 풀이는 좀더 고민해봐야 할거 같다.
* 시간복잡도 : word1 길이 * word2 길이
```java
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i =0 ; i <= n ; i++) {
            dp[i][m] = n - i;
        }
        for (int i = 0 ; i <= m ; i++) {
            dp[n][i] = m - i;
        }
        for (int i = n -1 ; i >= 0 ; i--) {
            for (int j = m - 1; j >= 0 ; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                }
                else {
                    dp[i][j] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i + 1][j + 1]) + 1;
                }
            }
        }
        return dp[0][0];
    }
}
```
