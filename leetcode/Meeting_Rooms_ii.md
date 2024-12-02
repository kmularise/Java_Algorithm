# 253. Meeting Rooms ii

- 문제 : https://neetcode.io/problems/meeting-schedule-ii
- 풀이 : 시간복잡도 O(n^2), 공간복잡도 O(n)
- 시간복잡도를 O(n log n)으로 줄여 보자.

```java
/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((x, y) -> Integer.compare(x.end, y.end));
        int end = Integer.MIN_VALUE;
        int count = 0;
        int[] ends = new int[intervals.size()];
        for (Interval interval : intervals) {
            boolean isAdded = true;
            for (int i = 0 ; i < count ; i++) {
                if (ends[i] <= interval.start) {
                    ends[i] = interval.end;
                    isAdded = false;
                    break;
                }
            }
            if (isAdded) {
                ends[count] = interval.end;
                count++;
            }
        }
        return count;
    }
}
```

