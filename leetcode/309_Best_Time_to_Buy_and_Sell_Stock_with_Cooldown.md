# 309. Best Time to Buy and Sell Stock with Cooldown
- 문제 : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
- 풀이 : 2차원 DP
- 점화식을 세울 때 다른 DP 풀이에서 하던 대로 하다가 꼬인 부분도 있었고, 문제의 조건을 잘못 읽기도 했다. 그래서 풀이에 불필요한 부분들이 들어가기도 했다.
- 점화식 세울 때는 좀 더 신경을 써야겠다.

```java
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length ; i++) {
            //사는 상태가 되자.
            //하루전에 보유를 하지 않았어야 함
            if (i == 1) {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            } else {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            }

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
```
