# 76. Minimum Window Substring
* 문제
* 슬라이딩 윈도우로 풀어도 되는데 다만 윈도우 크기가 가변이다.

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        
        int l = 0;
        int res = 0;
        for (int r = 0 ; r < s.length() ; r++) {
            //s.charAt(r)이랑 똑갈은 애가 나올 때까지 l++
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
```

* 각 character마다 last index를 저장하는 방식으로 풀어도 된다.
```java
import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[128];
        Arrays.fill(lastIndex, -1);
        int answer = 0;
        int start = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            start = Math.max(lastIndex[s.charAt(i)] + 1, start);
            answer = Math.max(i - start + 1, answer);
            lastIndex[s.charAt(i)] = i;
        }
        return answer;
    }
}
```
