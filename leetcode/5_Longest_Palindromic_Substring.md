# 5. Longest Palindromic Substring
* 최대 길이를 정하는 것에서 비효율적으로 생각해서 시간이 오래걸렸다.
* 좀더 효율적인 풀이로 다시 풀어볼 필요가 있다.
* 이풀이는 비효율적이었다. 점화식을 잘 지정하고, 기억을 할 필요가 있다. 
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

* 비효율적인 또다른 풀이 O(n^3)
```java
class Solution {
    boolean isValid(int start, int end, String s) {
        int mid = (start + end) / 2;
        for (int i = start ; i <= mid ; i++) {
            int j = start + end - i;
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    
    public String longestPalindrome(String s) {
        for (int length = s.length() ; length >= 1 ; length-- ) {
            for (int i = 0 ; i + length - 1 < s.length() ; i++) {
                if (isValid(i, i + length - 1, s)) {
                    return s.substring(i, i + length);
                }
            }
        }
        return null;
    }
}
```
DP를 이용한 풀이 O(n^2)
```java
class Solution {
    boolean[][] dp;
    public String longestPalindrome(String s) {
        dp = new boolean[s.length()][s.length()];
        int start = 0;
        int end = 0;
        //1개짜리
        for (int i = 0 ; i < s.length() ; i++) {
            dp[i][i] = true;
        }
        //2개짜리
        for (int i = 0 ; i < s.length() - 1 ; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                end = i + 1;
            }
        }
        //3개짜리 이상
        for (int diff = 2; diff < s.length() ; diff++) {
            for (int i = 0 ; i < s.length() - diff ; i++) {
                if (s.charAt(i) == s.charAt(i + diff) && dp[i + 1][i + diff - 1]) {
                    dp[i][i + diff] = true;
                    start = i;
                    end = i + diff;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
```
