# 416. Partition Equal Subset Sum
* knap sack 문제와 일부 비슷한 거 같다.
* DP 문제
* 시간복잡도 : n * sum /2 (200 * 10000)
* 문제 : https://leetcode.com/problems/partition-equal-subset-sum/description/

```java
class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;

        }
        if (total % 2== 1) {
            return false;
        }
        int target = total / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1]; // i번째 요소, i번째 요소까지의 부분집합의 합 
        for (int i = 0 ; i < n + 1 ; i++) {
            dp[i][0] = true;
        }
        for (int i = 1 ; i < n + 1 ; i++) {
            for (int j = 1 ; j <= target ; j++) {
                if (nums[i - 1] <= j && dp[i - 1][j - nums[i - 1]]) {
                    dp[i][j] = true;
                }
                else if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][target];
    }
}
```
