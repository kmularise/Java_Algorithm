# 91. Decode Ways
https://leetcode.com/problems/decode-ways/
* DP
* O(n)
```java
class Solution {
    public int getTwoNumbers(String s, int idx) {
        if (idx == 0) {
            throw new RuntimeException();
        }
        int number = (s.charAt(idx - 1) - '0') * 10 + (s.charAt(idx) - '0');
        if (number >= 10 && number <= 26) {
            return 1;
        }
        return 0;
    }

    public int getOneNumbers(String s, int idx) {
        int number = s.charAt(idx) - '0';
        if (number == 0) {
            return 0;
        }
        return 1;
    }
    public int numDecodings(String s) {
        //1칸 전진 또는 두칸 전진
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        if (s.length() == 1) {
            return dp[0];
        }
        dp[1] = dp[0] * getOneNumbers(s, 1) + getTwoNumbers(s, 1);
        for (int i = 2 ; i < s.length() ; i++) {
            dp[i] = dp[i - 1] * getOneNumbers(s, i) + dp[i - 2] * getTwoNumbers(s, i); 
        }
        return dp[s.length() - 1];
    }
}
```
