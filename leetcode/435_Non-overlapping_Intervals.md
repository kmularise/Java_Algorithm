# 435. Non-overlapping Intervals
* 문제 : https://leetcode.com/problems/non-overlapping-intervals/description/
* 그리디, 회의실 배정문제와 유사하다.
* 완전탐색을 하는 경우는 O(2^n) 정도의 시간복잡도가 나오는데, n이 범위가 10000개까지 나오므로 완전탐색은 적절할지 않다.
* 최소의 개수를 제외하는 것은 결국 최대의 개수를 포함시키는 것이다. 따라서 겹치지 않으면서 가장 많은 걸 포함하려면 어떤 것부터 탐색해야 할까?
  * 답은 가장 먼저 끝나는 구간 순으로 탐색해야 한다. 이는 귀납법으로 증명이 가능한데, 가장 먼저 끝나지 않는 구간을 선택하지 않고 만약 가장 먼저 끝나지 않는 다른 구간을 선택한다고 가정하면, 선택할 수 있는 집합의 범위가 좁아지기 때문에 모순이 발생한다. 따라서 가장 먼저 끝나느 구간을 선택해야 하는 것이다.
```java
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[1], y[1]));
        int count = 1;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1 ; i < intervals.length ; i++) {
            int ts = intervals[i][0];
            int te = intervals[i][1];
            if (ts >= end) {
                count++;
                start = ts;
                end = te;
            }
        } 
        return intervals.length - count;
    }
}
```
