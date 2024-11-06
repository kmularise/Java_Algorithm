# 3324. Find the Sequence of Strings Appeared on the Screen
- 풀이 : String, 시뮬레이션
- 문제 : https://leetcode.com/problems/find-the-sequence-of-strings-appeared-on-the-screen/
```java
class Solution {
    public char getNextChar(char current) {
        int idx = current - 'a';
        int nextIdx = (idx + 1) % 26;
        return (char) ('a' + nextIdx);
    }
    public List<String> stringSequence(String target) {
        char current = 'a';
        List<String> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : target.toCharArray()) {
            sb.append('a');
            while (true) {
                answer.add(sb.toString());
                char lastChar = sb.charAt(sb.length() - 1);
                if (lastChar == ch) {
                    break;
                }
                sb.setCharAt(sb.length() - 1, getNextChar(lastChar));
            }
        }
        return answer;
    }
}
```
