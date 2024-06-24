# 76. Minimum Window Substring
* 가변길이의 슬라이딩 윈도우
* [567_Permutation_in_String.md](567_Permutation_in_String.md)와 비슷하다.
* 각 요소의 개수는 HashMap을 이용해서 저장한다.
* 전체 요소의 개수는 따로 저장한다.
```java
class Solution {
    private static final String EMPTY = "";
    public String minWindow(String s, String t) {
        //가변 길이의 슬라이딩 윈도우
        Map<Character, Integer> target = new HashMap<>();
        for (int i = 0 ; i < t.length() ; i++) {
            int temp = target.getOrDefault(t.charAt(i), 0);
            target.put(t.charAt(i) ,temp + 1);
        }
        Map<Character, Integer> count = new HashMap<>();
        for (char element : target.keySet()) {
            count.put(element, 0);
        }
        int l = 0;
        int c = 0;
        //
        int minVal = Integer.MAX_VALUE;
        int lIdx = -1;
        int rIdx = -1;
        for (int r = 0 ; r < s.length() ; r++) {
            char element = s.charAt(r);
            if (target.containsKey(element)) {
                int temp = count.get(element);
                if (temp < target.get(element)) {
                    c++;
                }
                count.put(element ,temp + 1);
            }
            if (r >= t.length() - 1) {
                while (l < s.length()) {
                    char character = s.charAt(l);
                    if (target.containsKey(character)) {
                        int leftCount = count.get(character);
                        if (leftCount > target.get(character)) {
                            count.put(character, leftCount - 1);
                        } else {
                            // count.put(character, leftCount - 1);
                            break;
                        }
                    }
                    l++;
                }
                if (c == t.length()) {
                    if (minVal > r - l + 1) {
                        minVal = r - l + 1;
                        lIdx = l;
                        rIdx = r;
                    }
                }
            }
        }
        System.out.println(lIdx + " " + rIdx);
        if (lIdx == -1) {
            return EMPTY;
        }
        return s.substring(lIdx, rIdx + 1);
    }
}
```
