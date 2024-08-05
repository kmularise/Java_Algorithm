# 481. Magical String
* 투포인터
* 시간 복잡도 : O(n)
* 문제 : https://leetcode.com/problems/magical-string/
```java
class Solution {
    public int magicalString(int n) {
        int[] dp = new int[n + 1];
        int prev = 1;
        dp[0] = prev;
        dp[1] = 2;
        int i = 1;
        int j = 1;
        while (i < n) {
            if (prev == 1) {
                prev = 2;
            } else {
                prev = 1;
            }
            for (int k = 0 ; k < dp[i] ; k++) {
                if (j == n) break;
                dp[j] = prev;
                j++;
            }
            i++;
            if (j == n) break;
        }
        int answer = 0;
        for (int x = 0 ; x < n ; x++) {
            if (dp[x] == 1) {
                answer++;
            }
        }
        return answer;
    }
}
```
