# 91. Decode Ways
- 문제 : https://leetcode.com/problems/decode-ways/description/
- 풀이 : DP
- 01, 09 와 같은 케이스를 주의해야 했다. String으로 숫자를 문자열로 변환해서 Map의 키를 썼지만 예외 처리를 잘한다면 숫자로 써도 무관할 거 같다.
- 시간복잡도 : O(n)
```java
import java.util.*;
class Solution {
    public int numDecodings(String s) {
        Map<String, Character> alphabets = new HashMap<>();
        for (char alphabet = 'A' ; alphabet <= 'Z' ; alphabet++) {
            Integer number = (alphabet - 'A') + 1;
            alphabets.put(number.toString(), alphabet);
        }
        //String으로 둘 필요가 있다.
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length() ; i++) {
            //i - 1 i
            String oneDigit = s.substring(i - 1, i);
            if (alphabets.get(oneDigit) != null) {
                dp[i] = dp[i] + dp[i - 1];
            }
            //i - 2 i
            if (i - 2 >= 0) {
                String twoDigit = s.substring(i - 2, i);
                if (alphabets.get(twoDigit) != null) {
                    dp[i] = dp[i] + dp[i - 2];
                }
            }
        }
        return dp[s.length()];
    }
}
```
