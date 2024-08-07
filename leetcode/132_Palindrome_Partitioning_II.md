# 132. Palindrome Partitioning II
* 리트코드 랜덤 디펜스 
* 완전 탐색으로도 가능할 수 있지만, 반복되는 부분이 있고 (start, end)의 문자열이 palindrome인지를 확인하기 위해서 (start - 1, end - 1)의 정보를 이용하면 좋을 거 같다고 생각했다. 또한 각 지점에서 나눠지는 부분의 최소 개수를 구할 때 그리디적인 방법은 허용되지 않는다고 생각하였다. 이 두가지 부분에서 DP 알고리즘을 사용하게 되었다.
* 자잘하게 점화식을 세울 때 틀리는 부분들이 많았고, 이러한 부분을 조정한 후에야 테스트 케이스를 모두 통과할 수 있었다.
```java
class Solution {
    public int minCut(String s) {
        char[] array = s.toCharArray();
        int[][] dp = new int[array.length][array.length];
        int[] count = new int[array.length];
        //start end
        for (int i = 0 ; i < array.length ; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0 ; i < array.length -1 ; i++) {
            if (array[i] == array[i + 1]) {
                dp[i][i + 1] = 1;
            }
        }
        for (int len = 2; len < array.length ; len++) {
            for (int i = 0 ; i < array.length - len ; i++) {
                if (array[i] == array[i + len] && dp[i + 1][i + len - 1] == 1) {
                    dp[i][i + len] = 1;
                }
            }
        }
        count[0] = 0;
        Arrays.fill(count, Integer.MAX_VALUE);
        for (int end = 0 ; end < array.length ; end++) {
            for (int start = 0 ; start <= end ; start++) {
                if (dp[start][end] == 0) continue;
                if (start != 0) {
                    count[end] = Math.min(count[start - 1] + dp[start][end], count[end]);
                } else {
                    count[end] = dp[start][end];
                }
            }
        }
        return count[array.length - 1] - 1;
    }
}
```
