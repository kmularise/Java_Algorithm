# 96. Unique Binary Search Trees
- DP
```java
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2 ; i <= n ; i++) {
            for (int j = 0; j <= i - 1 ; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}
```
