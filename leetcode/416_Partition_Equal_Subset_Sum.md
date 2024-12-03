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

* 다른 풀이
# 416. Partition Equal Subset Sum
- 문제 : https://leetcode.com/problems/partition-equal-subset-sum/description/
- 각 숫자를 한번만 더하게끔 해서 DP 알고리즘 로직을 작성해야 했다.

```java
class Solution {
    public boolean canPartition(int[] nums) {
        //전체 합
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % 2 != 0) {
            return false;
        }
        int[] dp = new int[total + 1];
        dp[0] = 1;

        for (int num : nums) {
            List<Integer> targets = new ArrayList<>();
            for (int sum = 0 ; sum <= total ; sum++) {
                if (dp[sum] == 1 && sum + num <= total) {
                    targets.add(sum + num);
                }
            }
            for (int target : targets) {
                dp[target] = 1;
            }
        }
        for (int sum = 0 ; sum <= total ; sum++) {
            if (dp[sum] == 1 && total / 2 == sum) {
                return true;
            }
        }
        return false;
    }
}
```
