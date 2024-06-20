# 424. Longest Repeating Character Replacement
* https://leetcode.com/problems/longest-repeating-character-replacement/description/
* 슬라이딩 윈도우
```java
class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int answer = 0;
        int maxVal = 0;
        int l = 0;
        for (int r= 0 ; r < s.length() ; r++) {
            count[s.charAt(r) - 'A']++;
            maxVal = Math.max(maxVal, count[s.charAt(r) - 'A']);
            if (r - l + 1 - maxVal > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }
            answer = Math.max(answer, r - l + 1);
        }
        return answer;
    }
}
```
