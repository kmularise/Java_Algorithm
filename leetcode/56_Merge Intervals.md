# 56. Merge Intervals
* 문제 : https://leetcode.com/problems/merge-intervals/
* 시간 복잡도 : O(n log(n)) - 정렬해야 되서 시간 복잡도가 더커졌다.
* 실수한 부분 : 정렬되어 있다는 조건이 없는데도 정렬를 하지 않았다.
    
```java
class Solution {
    public int[][] merge(int[][] intervals) {
        int prevStart = -1;
        int prevEnd = -1;
        List<int[]> answerList = new ArrayList<>();
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        for (int[] interval : intervals) {
            if (interval[0] > prevEnd) {
                if (prevEnd != -1) {
                    answerList.add(new int[]{prevStart, prevEnd});
                }
                prevStart = interval[0];
                prevEnd = interval[1];
                continue;
            }
            if (interval[1] > prevEnd) {
                prevEnd = interval[1];
            }
        }
        answerList.add(new int[]{prevStart, prevEnd});
        return answerList.toArray(new int[answerList.size()][2]);
    }
}
```
