# 51. N-Queens
* 문제 :https://leetcode.com/problems/n-queens/description/
* 백트래킹
* 시간복잡도 O(N!)
```java
class Solution {
    List<List<String>> answers = new ArrayList<>();
    int n;
    public List<String> makeFormat(int[] pos) {
        List<String> target = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) {
            char[] array = new char[n];
            for (int j = 0 ; j < n ; j++) {
                if (pos[i] == j) {
                    array[j] = 'Q';
                }
                else {
                    array[j] = '.';
                }
            }
            String element = String.valueOf(array);
            target.add(element);
        }
        return target;
    }
    public void backTracking(int[] pos, int idx) {
        if (idx == n) {
            answers.add(makeFormat(pos));
            return;
        }
        for (int j = 0 ; j < n ; j++) {
            boolean isValid = true;
            for (int before = 0; before < idx ; before++) {
                if (Math.abs(pos[before] - j) == Math.abs(before - idx)) {
                    isValid = false;
                    continue;
                }
                if (pos[before] == j) {
                    isValid = false;
                    continue;
                }
            }
            if (isValid) {
                pos[idx] = j;
                backTracking(pos, idx + 1);
            }

        }
    }
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        int[] pos = new int[n];
        backTracking(pos, 0);
        return answers;
    }
}
```
