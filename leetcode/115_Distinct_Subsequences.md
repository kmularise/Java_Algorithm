# 115. Distinct Subsequences
* 문제 : https://leetcode.com/problems/distinct-subsequences/
* DP
* 시간 복잡도 : s의 길이 * t의 길이
* 문제해결과정
  * 완전탐색을 할 경우, 중복되는 부분이 있을 것이라 판단했다. 따라서 이전 정보들을 저장해놓으면 좋을 거 같다고 생각했다. 또한 i, i -1, j, j-1의 관계가 점화식으로 나오기에 DP를 풀이 방법으로 선택하게 되었다. 
```java
class Solution {
    public int numDistinct(String s, String t) {
        //s의 인덱스, t의 인덱스
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        //s의 i가 t의 j와 같다면 그 이전의 i j - 1의 개수를 더해줘야 한다.
        
        for (int j = 1 ; j <= t.length() ; j++) {
            for (int i = 1 ; i <= s.length() ; i++) {
                if (t.charAt(j - 1) == s.charAt(i - 1)) {
                    if (j == 1) {
                        dp[j][i] = dp[j][i - 1] + 1;
                    } else {
                        dp[j][i] = dp[j][i - 1] + dp[j - 1][i - 1];
                    }
                } else {
                    dp[j][i] = dp[j][i - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
```
