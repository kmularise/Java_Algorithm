# 5. Longest Palindromic Substring
* 최대 길이를 정하는 것에서 비효율적으로 생각해서 시간이 오래걸렸다.
* 좀더 효율적인 풀이로 다시 풀어볼 필요가 있다.
* DP로 분류되어 있었는데 왜 이게 DP인지는 잘 모르겠따.
```java
class Solution {
    int[] dp;
    Map<Character, List<Integer>> firstIndex = new HashMap<>();

    public boolean isValid(int start, int end, String s) {
        for (int i = 0 ; i < (end - start + 1) / 2  ; i++) {
            int left = start + i;
            int right = end - i;
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome(String s) {
        int start = -1; 
        int end = -1;
        int maxVal = -1;
        for (int i = 0 ; i < s.length() ; i++) {
            if (firstIndex.get(s.charAt(i)) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                firstIndex.put(s.charAt(i), list);
            } else {
                List<Integer> beforeIndexes = firstIndex.get(s.charAt(i));
                for (int beforeIndex : beforeIndexes) {
                    int length = i - beforeIndex;
                    if (length > maxVal) {
                        if (isValid(beforeIndex, i, s)) {
                            maxVal = length;
                            start = beforeIndex;
                            end = i;
                        }
                    }
                }
                beforeIndexes.add(i);
            }
        }
        if (start == -1 || end == -1) {
            start = 0;
            end = 0;
        }
        return s.substring(start, end + 1);
        // return null;
    }
}
```
