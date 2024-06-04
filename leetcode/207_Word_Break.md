# 139. Word Break
* 문제 : https://leetcode.com/problems/word-break/description/
* DP, 시간 복잡도 O(n) if 문을 줄여보는 것도 좋을 거 같다.
```java
class Solution {
    boolean[] isStart;
    public boolean isValid(int start, String target, String src) {
        int length = src.length();
        if (start + length > target.length()) {
            return false;
        }
        for (int i = 0 ; i < length ; i++) {
            if (target.charAt(start + i) != src.charAt(i)) {
                return false;
            }
        }
        return true;
    } 
    public boolean wordBreak(String s, List<String> wordDict) {
        isStart = new boolean[s.length()];
        isStart[0] = true;
        for (int i = 0 ; i < s.length() ; i++) {
            if (!isStart[i]) continue;
            for (String word : wordDict) {
                if (isValid(i, s, word)) {
                    if (i + word.length() == s.length()) {
                        return true;
                    }
                    isStart[i + word.length()] = true;
                }
            }
        }
        return false;
    }
}
```
