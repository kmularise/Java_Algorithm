# 131. Palindrome Partitioning
* 문제 : https://leetcode.com/problems/palindrome-partitioning/description/
* 유형 : DP, 백트래킹
* 시간복잡도 : N * 2^N 각 문자열의 위치에서 자르거나 자르지 않는 선택을 하기 때문, N이 16으로 작기 때문에 시간 초과가 나지 않는 알고리즘이다.
* List remove 메소드는 ArrayList라면 성능 상 문제없어 보인다.
```java
class Solution {
    boolean[][] isValid;
    List<List<String>> answers = new ArrayList<>(); 

    public void dfs(int curr, String s, List<String> list) {
        if (s.length() == curr) {
            answers.add(new ArrayList<>(list));
            return;
        }
        for (int i = curr ; i < s.length() ; i++) {
            if (!isValid[curr][i]) continue;
            list.add(s.substring(curr, i + 1));
            dfs(i + 1, s, list);
            list.remove(list.size() - 1);
        }
    }
    public List<List<String>> partition(String s) {
        isValid = new boolean[s.length()][s.length()];
        for (int i = 0 ; i < s.length() ; i++) {
            isValid[i][i] = true;
        }
        for (int i = 0 ; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) continue;
            isValid[i][i + 1] = true;
        }
        for (int ds = 2 ; ds < s.length() ; ds++) {
            for (int i = 0 ; i < s.length() - ds ; i++) {
                if (s.charAt(i) != s.charAt(i + ds)) continue;
                if (!isValid[i + 1][i + ds - 1]) continue;
                isValid[i][i + ds] = true;
            }
        }
        dfs(0, s, new ArrayList<>());
        return answers;
    }
}
```
