# 3. Longest Substring Without Repeating Characters
- 풀이 : 가변 슬라이딩 윈도우
- 시간복잡도 : O(n)

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int answer = 0;
        int[] count = new int[257];
        while (end < s.length()) {
            while (count[s.charAt(end)] != 0 && start < end) {
                count[s.charAt(start)]--;
                start++;
            }
            count[s.charAt(end)]++;
            answer = Math.max(end - start + 1, answer);
            end++;
        }
        return answer;
    }
}
```
